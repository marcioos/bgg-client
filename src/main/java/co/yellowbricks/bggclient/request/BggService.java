package co.yellowbricks.bggclient.request;

import javax.inject.Inject;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import co.yellowbricks.bggclient.common.domain.Thing;

import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;

@Component
public class BggService {
	
	@Value("${SEARCH_URL}")
	private String searchURL;

	@Value("${FETCH_URL}")
	private String fetchURL;
	
	@Inject private RequestExecutor requestExecutor;
	
	public Source search(Thing thing, final String query) throws BggServiceException {
		return new StreamSource(requestExecutor.executeRequest(searchURL, thing, new ParameterAdder() {
			@Override
			public BoundRequestBuilder addParameters(BoundRequestBuilder requestBuilder) {
				return requestBuilder.addQueryParameter("query", query);
			}
		}));
	}
	
	public Source fetch(Thing thing, final int id) throws BggServiceException {
		return new StreamSource(requestExecutor.executeRequest(fetchURL, thing, new ParameterAdder() {
			@Override
			public BoundRequestBuilder addParameters(BoundRequestBuilder requestBuilder) {
				return requestBuilder.addQueryParameter("id", String.valueOf(id));
			}
		}));
	}
}
