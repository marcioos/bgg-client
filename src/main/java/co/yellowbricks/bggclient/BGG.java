package co.yellowbricks.bggclient;

import javax.xml.bind.JAXBException;

import co.yellowbricks.bggclient.common.NoItemsFoundException;
import co.yellowbricks.bggclient.fetch.FetchException;
import co.yellowbricks.bggclient.fetch.domain.FetchItem;
import co.yellowbricks.bggclient.fetch.domain.FetchItemOutput;
import co.yellowbricks.bggclient.fetch.domain.UserCollection;
import co.yellowbricks.bggclient.request.BggService;
import co.yellowbricks.bggclient.request.BggServiceException;
import co.yellowbricks.bggclient.search.SearchException;
import co.yellowbricks.bggclient.search.domain.SearchOutput;

public final class BGG {

    private BGG() {
    }

    public static SearchOutput search(String query) throws SearchException, NoItemsFoundException {
        try {
            SearchOutput items = (SearchOutput) SearchOutput.UNMARSHALLER.unmarshal(BggService.INSTANCE.search(query));

            if (items.getItems() != null && !items.getItems().isEmpty())
                return items;
            throw new NoItemsFoundException();
        } catch (BggServiceException e) {
            throw new SearchException("While searching for " + query, e);
        } catch (JAXBException e) {
            throw new SearchException("While searching for " + query, e);
        }
    }

    public static FetchItem fetch(int id) throws FetchException, NoItemsFoundException {
        try {
            FetchItemOutput items = (FetchItemOutput) FetchItemOutput.UNMARSHALLER.unmarshal(BggService.INSTANCE.fetch(id));

            if (items.getItems() != null && !items.getItems().isEmpty())
                return items.getItems().get(0);
            throw new NoItemsFoundException();
        } catch (BggServiceException e) {
            throw new FetchException("While fetching id: " + id, e);
        } catch (JAXBException e) {
            throw new FetchException("While fetching id: " + id, e);
        }
    }

    public static UserCollection fetchCollection(String ownerName) throws FetchException, NoItemsFoundException {
        try {
            UserCollection collection = (UserCollection) UserCollection.UNMARSHALLER.unmarshal(BggService.INSTANCE.fetchCollection(ownerName));

            if (collection.getItems() != null && !collection.getItems().isEmpty())
                return collection;
            throw new NoItemsFoundException();
        } catch (BggServiceException e) {
            throw new FetchException(String.format("While fetching %s's collection", ownerName), e);
        } catch (JAXBException e) {
            throw new FetchException(String.format("While fetching %s's collection", ownerName), e);
        }
    }
}
