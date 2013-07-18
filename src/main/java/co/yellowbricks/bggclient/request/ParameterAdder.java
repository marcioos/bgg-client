package co.yellowbricks.bggclient.request;

import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;

public interface ParameterAdder {
	
	public BoundRequestBuilder addParameters(BoundRequestBuilder requestBuilder);

}