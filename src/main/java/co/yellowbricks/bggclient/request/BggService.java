package co.yellowbricks.bggclient.request;

import javax.inject.Inject;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;

@Component
public class BggService {
	
	@Value("${SEARCH_URL}")
	private String searchURL;

	@Value("${FETCH_URL}")
	private String fetchURL;
	
	@Value("${COLLECTION_URL}")
	private String collectionURL;
	
	@Inject private HttpRequester httpRequester;
	
	public Source search(final String query) throws BggServiceException {
		return new StreamSource(httpRequester.executeRequest(searchURL, new ParameterAdder() {
			@Override
			public BoundRequestBuilder addParameters(BoundRequestBuilder requestBuilder) {
				return requestBuilder.addQueryParameter("query", query);
			}
		}));
	}
	
	public Source fetch(final int id) throws BggServiceException {
		return new StreamSource(httpRequester.executeRequest(fetchURL, new ParameterAdder() {
			@Override
			public BoundRequestBuilder addParameters(BoundRequestBuilder requestBuilder) {
				return requestBuilder.addQueryParameter("id", String.valueOf(id));
			}
		}));
	}
	
	public Source fetchCollection(final String ownerName) throws BggServiceException {
		return new StreamSource(httpRequester.executeRequest(collectionURL, new ParameterAdder() {
			@Override
			public BoundRequestBuilder addParameters(BoundRequestBuilder requestBuilder) {
				return requestBuilder.addQueryParameter("username", ownerName);
			}
		}));
	}
}
