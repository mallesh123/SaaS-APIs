package com.SaaS_APIs.common;

import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import com.SaaS_APIs.constants.*;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ServiceUnavailableRetryStrategy;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.testng.Reporter;

public abstract class CommonTestClient {

	public static int GET_METHOD = 1;

	public static int POST_METHOD = 2;

	public static int PUT_METHOD = 3;

	public static int DELETE_METHOD = 4;
	
	public static int PATCH_METHOD = 5;

	HttpUriRequest request;
	
	public static String 	host;	
	public static int		port = 80;	
	public static String 	protocol;
	public static HttpClient    httpClient;
	
	
	protected static CloseableHttpClient getHttpClient() {
		try{
			HttpClientBuilder hcBuilder = HttpClients.custom();
			@SuppressWarnings("deprecation")
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial((KeyStore)null, new TrustStrategy() {
	    		        public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
			            return true;
			        }
			    })
			.useProtocol("TLSv1.2")
			.build();
		    hcBuilder.setSslcontext( sslContext);
		    //Contexts.custom().useProtocol("TLSv1").build())
			HostnameVerifier hostnameVerifier = SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;			
			SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
			
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
		            .register("http", PlainConnectionSocketFactory.getSocketFactory())
		            .register("https", sslSocketFactory)
		            .build();
			
			System.setProperty("java.net.preferIPv4Stack" , "true");
			PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
	        cm.setMaxTotal(2000);	//max connection
	        hcBuilder.setConnectionManager(cm);
	        hcBuilder.setServiceUnavailableRetryStrategy(new ServiceUnavailableRetryStrategy() {				
	        	public boolean retryRequest(
	                final HttpResponse response, final int executionCount, final HttpContext context) {
	                int statusCode = response.getStatusLine().getStatusCode();
	                // Changing it to 403 because, there is no meaning in retrying if the credentails are wrong. 
	                return statusCode > 403 && executionCount < 5;
	            }
				
				public long getRetryInterval() {
					return 10000;
				}
			});
			return hcBuilder.build();
		}
		catch(Exception e) {
			System.out.print(e);
			return null;
		}		
	}
	
	/*
	public static HttpClient getHttpClient(){
		
		
		
		
		try {
			System.setProperty("java.net.preferIPv4Stack" , "true");
	        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
	        cm.setMaxTotal(2000);//max connection
			CloseableHttpClient httpClient = HttpClients.custom()
														.setConnectionManager(cm)
														.setRedirectStrategy(new LaxRedirectStrategy())
														.build();
		    return httpClient;		
			
			
			
			SSLContextBuilder builder = new SSLContextBuilder();
		    builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
		    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
		            builder.build());
			
                        
			
//                    SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(
//                            SSLContext.getDefault(), //for you this is builder.build()
//                            SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);  
			
			
			
			
                    
			System.setProperty("java.net.preferIPv4Stack" , "true");
			SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(
			        SSLContext.getDefault(),
			        new String[] { "SSLv2Hello","SSLv3","TLSv1","TLSv1.1","TLSv1.2", "TLVv1.3"},
			        null,
			        SSLConnectionSocketFactory.getDefaultHostnameVerifier());
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
			        .register("http", PlainConnectionSocketFactory.getSocketFactory())
			        .register("https", socketFactory)
			        .build();

			PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
			CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
			return httpClient;
		}
		
		
		catch(Exception e) {
			System.out.print(e);
			return null;
		}
		
	}*/

	/**
	 * 
	 * @param requestType
	 * @param uri
	 * @param headers
	 * @param entity
	 * @param matrixParams
	 * @return
	 * @throws Exception
	 */
	protected HttpResponse executeRequest(int requestType, java.net.URI uri, List<NameValuePair> headers, 
			HttpEntity entity, List<NameValuePair> matrixParams) throws Exception {

		try {
			request = contructRequest(requestType, uri, headers, entity, matrixParams);			
			if(headers != null) {
				setHeaders(headers);
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}

		HttpResponse response = null;
		try {

			for(int i = 0; i < com.SaaS_APIs.constants.CommonConstants.REQEUST_RETRY_ATTEMPTS; i++) {
				if(headers != null) {
					setHeaders(headers);
				}
				try { 
					 
			        response = getHttpClient().execute(request);
				} 
				catch(Exception e) {
                                        System.out.println("Exception in Response :"+e.getLocalizedMessage());
					System.out.println("Retrying request ...");
					request.abort();					
					request = contructRequest(requestType, uri, headers, entity, matrixParams);
					continue;
				}
				break;
			}

			if(response == null) 
				System.out.println("************************************** Response is null **************************************");
			
		}
		catch (Exception e) {
			e.printStackTrace();
			request.abort();
		}

		return response;
	}	

	public HttpUriRequest contructRequest(int requestType, java.net.URI uri, List<NameValuePair> headers, 
											HttpEntity entity, List<NameValuePair> matrixParams) throws Exception {
		
		HttpUriRequest individualRequest = null;
		if (matrixParams == null) {
			matrixParams = new ArrayList<NameValuePair>();
		}

		Iterator<NameValuePair> iterator = matrixParams.iterator();
		while(iterator.hasNext()) {
			//NameValuePair par = iterator.next();
			//sb.append(" --data \"").append(par.getName()).append(":").append(par.getValue()).append("\"");
		}	

		switch(requestType) {
		case 1:			
			HttpGet httpGet = new HttpGet(uri);
			individualRequest = httpGet;			
			Reporter.log("GET " + uri.toString(), true);
			break;
			
		case 2:
			HttpPost httpPost = new HttpPost(uri);
			if(entity != null) {
				httpPost.setEntity(entity);
				//System.out.println("Entity String:"+EntityUtils.toString(entity));
			}
			if(matrixParams != null && matrixParams.size() > 0) {
				httpPost.setEntity(new UrlEncodedFormEntity(matrixParams, "UTF-8"));
			}
			individualRequest = httpPost;
			Reporter.log("POST Request:"+uri.toString(), true);
			break;
			
		case 3:
			HttpPut httpPut = new HttpPut(uri);
			if(entity != null) httpPut.setEntity(entity);
			if(matrixParams != null && !matrixParams.isEmpty()) 
				httpPut.setEntity(new UrlEncodedFormEntity(matrixParams, "UTF-8"));
			individualRequest = httpPut;
			Reporter.log("PUT Request:"+uri.toString(), true);
			break;
			
		case 4:
			HttpDelete httpDelete = new HttpDelete(uri);
			individualRequest = httpDelete;
			Reporter.log("DELETE Request:"+uri.toString(), true);
			break;		
		case 5:
			HttpPatch httpPatch = new HttpPatch(uri);
			if(entity != null) {
				httpPatch.setEntity(entity);
			}
			if(matrixParams != null && matrixParams.size() > 0) {
				httpPatch.setEntity(new UrlEncodedFormEntity(matrixParams, "UTF-8"));
			}
			individualRequest = httpPatch;
			Reporter.log("PATCH Request:"+uri.toString(), true);
			break;
			
		}
		
		
		
			
		return individualRequest;
	}


	/**
	 * 
	 * @param requestType
	 * @param uri
	 * @param headers
	 * @param entity
	 * @param matrixParams
	 * @return
	 * @throws Exception
	 */
	public HttpResponse executeRestRequest(int requestType, java.net.URI uri, List<NameValuePair> headers, 
			HttpEntity entity, List<NameValuePair> matrixParams) throws Exception {

		HttpResponse response = null;
		
		
		
		response = executeRequest(requestType, uri, headers, entity, matrixParams);
		return response;
	}

	

	/**
	 * 
	 * @param headers
	 */
	private void setHeaders(List<NameValuePair> headers) {
		Iterator<NameValuePair> iterator = headers.iterator();
		while(iterator.hasNext()) {
			NameValuePair header = iterator.next();
			request.setHeader(header.getName(), header.getValue());
		}
	}	

	/**
	 * 
	 * @param is
	 * @return
	 */
	public byte[] toByteArray(InputStream is) {

		try {
			ByteArrayOutputStream data = new ByteArrayOutputStream();
			byte buffer[] = new byte[4096];  // 4kB
			for( int bytes = is.read(buffer, 0, buffer.length); 
					bytes != -1; 
					bytes = is.read(buffer, 0, buffer.length) )
			{
				data.write(buffer, 0, bytes);
			}
			return data.toByteArray();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Return current date time
	 * @return
	 */
	public String currentDateTime() {
		Calendar cal = new GregorianCalendar();

		int year = cal.get(Calendar.YEAR);             // 2002
		int month = cal.get(Calendar.MONTH);           // 0=Jan, 1=Feb, ...
		int day = cal.get(Calendar.DAY_OF_MONTH);      // 1...

		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		StringBuffer dateTime = new StringBuffer();
		dateTime.append(month+1).append("/").append(day).append("/").append(year).append(" ").append(hour)
											.append(":").append(minute).append(":").append(second);
		return dateTime.toString();
	}
	
	

}
