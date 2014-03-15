package co.yellowbricks.bggclient;

import java.util.Collection;

import retrofit.RetrofitError;
import co.yellowbricks.bggclient.common.NoItemsFoundException;
import co.yellowbricks.bggclient.common.ThingType;
import co.yellowbricks.bggclient.fetch.FetchException;
import co.yellowbricks.bggclient.fetch.domain.FetchItem;
import co.yellowbricks.bggclient.fetch.domain.FetchItemOutput;
import co.yellowbricks.bggclient.fetch.domain.UserCollection;
import co.yellowbricks.bggclient.search.SearchException;
import co.yellowbricks.bggclient.search.domain.SearchOutput;

public final class BGG {

    private BGG() {
    }

    public static SearchOutput search(String query, ThingType... thingTypes) throws SearchException, NoItemsFoundException {
        try {
            SearchOutput items =
                    BggService.SingletonHolder.getInstance().search(query, getTypesQueryString(thingTypes));

            if (items.getItems() != null && !items.getItems().isEmpty())
                return items;
            throw new NoItemsFoundException();
        } catch (RetrofitError e) {
            throw new SearchException("While searching for " + query, e);
        }
    }

    public static Collection<FetchItem> fetch(Collection<Integer> ids, ThingType... thingTypes) throws FetchException, NoItemsFoundException {
        try {
            FetchItemOutput items =
                    BggService.SingletonHolder.getInstance().fetch(getIdsAsString(ids), getTypesQueryString(thingTypes));

            if (items.getItems() != null && !items.getItems().isEmpty())
                return items.getItems();
            throw new NoItemsFoundException();
        } catch (RetrofitError e) {
            throw new FetchException("While fetching ids: " + ids, e);
        }
    }

    public static UserCollection fetchCollection(String ownerName) throws FetchException, NoItemsFoundException {
        try {
            UserCollection collection = BggService.SingletonHolder.getInstance().fetchCollection(ownerName, 1);

            if (collection.getItems() != null && !collection.getItems().isEmpty())
                return collection;
            throw new NoItemsFoundException();
        } catch (RetrofitError e) {
            throw new FetchException("While fetching %s's collection " + ownerName, e);
        }
    }

    private static String getTypesQueryString(ThingType... thingTypes) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < thingTypes.length; i++) {
            builder.append(thingTypes[i].getKey());
            if (i < (thingTypes.length - 1)) builder.append(",");
        }
        return builder.toString();
    }

    private static String getIdsAsString(Collection<Integer> ids) {
        StringBuilder builder = new StringBuilder();
        for (Integer id : ids) {
            builder.append(String.valueOf(id));
            builder.append(',');
        }
        return builder.length() > 0 ? builder.substring(0, builder.length() - 1): "";
    }
}
