package co.yellowbricks.bggclient.request;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.yellowbricks.bggclient.common.domain.Thing;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;

@Service
public class BggService {
	
	private static final String BGG_BASE_URL = "http://www.boardgamegeek.com/xmlapi2";
	private static final String BGG_SEARCH_URL = BGG_BASE_URL + "/search";
	private static final String BGG_FETCH_URL = BGG_BASE_URL + "/thing";
	
	public InputStream search(Thing thing, String query) throws BggServiceException {
		AsyncHttpClient httpClient = new AsyncHttpClient();
		try {
			Future<Response> future = 
					httpClient.prepareGet(BGG_SEARCH_URL).addQueryParameter("type", thing.getType()).addQueryParameter("query", query).execute();
			return future.get().getResponseBodyAsStream();
		} catch (InterruptedException e) {
			throw createSearchException(thing, query, e);
		} catch (ExecutionException e) {
			throw createSearchException(thing, query, e);
		} catch (IOException e) {
			throw createSearchException(thing, query, e);
		} finally {
			httpClient.close();
		}
	}

	private BggServiceException createSearchException(Thing thing, String query, Throwable e) {
		return new BggServiceException(String.format("While searching for %s with query %s", thing, query), e);
	}
}
