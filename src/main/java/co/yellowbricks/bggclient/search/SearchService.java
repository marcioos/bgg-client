package co.yellowbricks.bggclient.search;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;

import co.yellowbricks.bggclient.fetch.domain.FetchedItems;
import co.yellowbricks.bggclient.search.domain.SearchedItems;

public class SearchService {

	public SearchedItems search(String query) throws SearchException {
		AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
		Future<Response> f;
		try {
			f = asyncHttpClient.prepareGet("http://www.boardgamegeek.com/xmlapi2/search").addQueryParameter("query", query).addQueryParameter("type", "boardgame").execute();
			JAXBContext jaxbContext = JAXBContext.newInstance(FetchedItems.class, SearchedItems.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			return (SearchedItems) unmarshaller.unmarshal(f.get().getResponseBodyAsStream());
		} catch (JAXBException e) {
			throw new SearchException("While searching for " + query, e);
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
