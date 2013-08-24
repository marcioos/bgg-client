package co.yellowbricks.bggclient.request;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;

public enum BggService {
	
	INSTANCE;

	private static final String BASE_URL = "http://www.boardgamegeek.com/xmlapi2";
	private static final String SEARCH_URL = BASE_URL + "/search";
	private static final String FETCH_URL = BASE_URL + "/thing";
	private static final String COLLECTION_URL = BASE_URL + "/collection";
	
	public Source search(final String query) throws BggServiceException {
		return new StreamSource(HttpRequester.INSTANCE.executeRequest(SEARCH_URL, new ParameterAdder() {
			@Override
			public BoundRequestBuilder addParameters(BoundRequestBuilder requestBuilder) {
				return requestBuilder.addQueryParameter("query", query);
			}
		}));
	}
	
	public Source fetch(final int id) throws BggServiceException {
		return new StreamSource(HttpRequester.INSTANCE.executeRequest(FETCH_URL, new ParameterAdder() {
			@Override
			public BoundRequestBuilder addParameters(BoundRequestBuilder requestBuilder) {
				return requestBuilder.addQueryParameter("id", String.valueOf(id));
			}
		}));
	}
	
	public Source fetchCollection(final String ownerName) throws BggServiceException {
		return new StreamSource(HttpRequester.INSTANCE.executeRequest(COLLECTION_URL, new ParameterAdder() {
			@Override
			public BoundRequestBuilder addParameters(BoundRequestBuilder requestBuilder) {
				return requestBuilder.addQueryParameter("username", ownerName);
			}
		}));
	}
}
