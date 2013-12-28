package co.yellowbricks.bggclient.request;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.AsyncHttpClientConfig.Builder;
import com.ning.http.client.Response;

public enum HttpRequester {

    INSTANCE;

    private static final int REQUEST_TIMEOUT_MS = 180000;

    public InputStream executeRequest(String url, ParameterAdder parameterAdder) throws BggServiceException {
        AsyncHttpClient httpClient = createAsyncHttpClient();
		try {
			return executeRequest(parameterAdder.addParameters(httpClient.prepareGet(url)));
		} finally {
			httpClient.close();
		}
	}

    private AsyncHttpClient createAsyncHttpClient() {
        Builder clientConfig = new AsyncHttpClientConfig.Builder();
        clientConfig.setRequestTimeoutInMs(REQUEST_TIMEOUT_MS);
		return new AsyncHttpClient(clientConfig.build());
    }

	private InputStream executeRequest(BoundRequestBuilder request) throws BggServiceException {
		try {
			Future<Response> future = request.execute();
			return future.get(REQUEST_TIMEOUT_MS, TimeUnit.MILLISECONDS).getResponseBodyAsStream();
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