package co.yellowbricks.bggclient.request;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;
import com.ning.http.client.Response;

public enum HttpRequester {

    INSTANCE;

    public InputStream executeRequest(String url, ParameterAdder parameterAdder) throws BggServiceException {
		AsyncHttpClient httpClient = new AsyncHttpClient();
		try {
			return executeRequest(parameterAdder.addParameters(httpClient.prepareGet(url)));
		} finally {
			httpClient.close();
		}
	}

	private InputStream executeRequest(BoundRequestBuilder request) throws BggServiceException {
		try {
			Future<Response> future = request.execute();
			return future.get(3l, TimeUnit.MINUTES).getResponseBodyAsStream();
		} catch (InterruptedException e) {
			throw createException(request, e);
		} catch (ExecutionException e) {
			throw createException(request, e);
		} catch (IOException e) {
			throw createException(request, e);
		} catch (TimeoutException e) {
            throw createException(request, e);
        }
	}

	private BggServiceException createException(BoundRequestBuilder request, Throwable e) {
		return new BggServiceException(String.format("While processing request %s", request.build()), e);
	}
}