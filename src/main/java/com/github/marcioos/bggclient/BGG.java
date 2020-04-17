package com.github.marcioos.bggclient;

import com.github.marcioos.bggclient.common.ThingType;
import com.github.marcioos.bggclient.fetch.FetchException;
import com.github.marcioos.bggclient.fetch.domain.FetchItem;
import com.github.marcioos.bggclient.fetch.domain.FetchItemOutput;
import com.github.marcioos.bggclient.fetch.domain.UserCollection;
import com.github.marcioos.bggclient.search.SearchException;
import com.github.marcioos.bggclient.search.domain.SearchOutput;
import retrofit2.Response;

import java.util.Collection;

import static java.util.Collections.emptyList;

public final class BGG {

    private BGG() {
    }

    public static SearchOutput search(String query, ThingType... thingTypes) throws SearchException {
        try {
            Response<SearchOutput> searchResponse =
                    BggService.INSTANCE.search(query, getTypesQueryString(thingTypes)).execute();

            if (searchResponse.isSuccessful()) {
                if (searchResponse.body() != null && searchResponse.body().getTotal() > 0) {
                    return searchResponse.body();
                }
            }
            return null;
        } catch (Exception e) {
            throw new SearchException("While searching for " + query, e);
        }
    }

    public static Collection<FetchItem> fetch(Collection<Integer> ids, ThingType... thingTypes) throws FetchException {
        try {
            Response<FetchItemOutput> fetchResponse =
                    BggService.INSTANCE.fetch(getIdsAsString(ids), getTypesQueryString(thingTypes)).execute();

            if (fetchResponse.isSuccessful()) {
                return fetchResponse.body().getItems();
            }
            return emptyList();
        } catch (Exception e) {
            throw new FetchException("While fetching ids: " + ids, e);
        }
    }

    public static UserCollection fetchCollection(String ownerName) throws FetchException {
        try {
            Response<UserCollection> collectionResponse = BggService.INSTANCE.fetchCollection(ownerName, 1).execute();

            if (collectionResponse.isSuccessful() && collectionResponse.body() != null) {
                return collectionResponse.body();
            }
            return null;
        } catch (Exception e) {
            throw new FetchException("While fetching %s's collection " + ownerName, e);
        }
    }

    private static String getTypesQueryString(ThingType... thingTypes) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < thingTypes.length; i++) {
            builder.append(thingTypes[i].getKey());
            if (i < (thingTypes.length - 1)) {
                builder.append(",");
            }
        }
        return builder.toString();
    }

    private static String getIdsAsString(Collection<Integer> ids) {
        StringBuilder builder = new StringBuilder();
        for (Integer id : ids) {
            builder.append(String.valueOf(id));
            builder.append(',');
        }
        return builder.length() > 0 ? builder.substring(0, builder.length() - 1) : "";
    }
}
