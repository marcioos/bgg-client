package co.yellowbricks.bggclient.request;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import co.yellowbricks.bggclient.common.ThingType;

import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;

public enum BggService {
	
	INSTANCE;

	private static final String BASE_URL = "http://www.boardgamegeek.com/xmlapi2";
	private static final String SEARCH_URL = BASE_URL + "/search";
	private static final String FETCH_URL = BASE_URL + "/thing";
	private static final String COLLECTION_URL = BASE_URL + "/collection";
	
	public Source search(final String query, final ThingType... thingTypes) throws BggServiceException {
		return new StreamSource(HttpRequester.INSTANCE.executeRequest(SEARCH_URL, new ParameterAdder() {
			@Override
			public BoundRequestBuilder addParameters(BoundRequestBuilder requestBuilder) {
			    addThingTypesToQuery(requestBuilder, thingTypes);
				return addThingTypesToQuery(requestBuilder, thingTypes).addQueryParameter("query", query);
			}
		}));
	}
	
	public Source fetch(final int id, final ThingType... thingTypes) throws BggServiceException {
		return new StreamSource(HttpRequester.INSTANCE.executeRequest(FETCH_URL, new ParameterAdder() {
			@Override
			public BoundRequestBuilder addParameters(BoundRequestBuilder requestBuilder) {
				return addThingTypesToQuery(requestBuilder, thingTypes).addQueryParameter("id", String.valueOf(id));
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
	
	private BoundRequestBuilder addThingTypesToQuery(BoundRequestBuilder requestBuilder, final ThingType... thingTypes) {
	    if (thingTypes != null)
	        return requestBuilder.addQueryParameter("type", getTypesQueryString(thingTypes));
        return requestBuilder;
    }

    private String getTypesQueryString(ThingType... thingTypes) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < thingTypes.length; i++) {
            builder.append(thingTypes[i].getKey());
            if (i < (thingTypes.length - 1)) builder.append(",");
        }
        return builder.toString();
    }
}
