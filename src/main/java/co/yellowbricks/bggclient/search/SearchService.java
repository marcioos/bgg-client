package co.yellowbricks.bggclient.search;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.inject.Inject;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

import co.yellowbricks.bggclient.search.domain.SearchItems;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;

@Service
public class SearchService {
	
	@Inject @Search private Jaxb2Marshaller jaxb2Marshaller;

	public SearchItems search(String query) throws SearchException {
		AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
		Future<Response> f;
		try {
			f = asyncHttpClient.prepareGet("http://www.boardgamegeek.com/xmlapi2/search").addQueryParameter("query", query).addQueryParameter("type", "boardgame").execute();
			
			return (SearchItems) jaxb2Marshaller.unmarshal(new StreamSource(f.get().getResponseBodyAsStream()));
		} catch (IOException e) {
			throw new SearchException("While searching for " + query, e);
		} catch (InterruptedException e) {
			throw new SearchException("While searching for " + query, e);
		} catch (ExecutionException e) {
			throw new SearchException("While searching for " + query, e);
		} finally {
			asyncHttpClient.close();
		}
	}
}
