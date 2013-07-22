package co.yellowbricks.bggclient.fetch;

import javax.inject.Inject;

import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import co.yellowbricks.bggclient.common.NoItemsFoundException;
import co.yellowbricks.bggclient.common.domain.ThingType;
import co.yellowbricks.bggclient.fetch.domain.FetchItem;
import co.yellowbricks.bggclient.fetch.domain.FetchItemOutput;
import co.yellowbricks.bggclient.fetch.domain.UserCollection;
import co.yellowbricks.bggclient.request.BggService;
import co.yellowbricks.bggclient.request.BggServiceException;

@Service
public class FetchService {

	@Inject @FetchQualifier 
	private Jaxb2Marshaller jaxb2FetchMarshaller;

	@Inject @CollectionQualifier 
	private Jaxb2Marshaller jaxb2CollectionMarshaller;

	@Inject
	private BggService bgg;
	
	public FetchItem fetch(int id) throws FetchException, NoItemsFoundException {
		try {
			FetchItemOutput items = (FetchItemOutput) jaxb2FetchMarshaller.unmarshal(bgg.fetch(ThingType.BOARDGAME, id));

			if (!CollectionUtils.isEmpty(items.getItems()))
				return items.getItems().get(0);
			throw new NoItemsFoundException();
		} catch (XmlMappingException e) { 
			throw new FetchException("While fetching id: " + id, e);
		} catch (BggServiceException e) {
			throw new FetchException("While fetching id: " + id, e);
		}
	}
	
	public UserCollection fetchCollection(String ownerName) throws FetchException, NoItemsFoundException {
		try {
			UserCollection collection = (UserCollection) jaxb2CollectionMarshaller.unmarshal(bgg.fetchCollection(ownerName));
			
			if (!CollectionUtils.isEmpty(collection.getItems()))
				return collection;
			throw new NoItemsFoundException();
		} catch (XmlMappingException e) {
			throw new FetchException(String.format("While fetching %s's collection", ownerName), e);
		} catch (BggServiceException e) {
			throw new FetchException(String.format("While fetching %s's collection", ownerName), e);
		}
	}
}
