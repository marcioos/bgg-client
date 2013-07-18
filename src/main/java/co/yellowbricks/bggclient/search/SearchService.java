package co.yellowbricks.bggclient.search;

import javax.inject.Inject;

import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import co.yellowbricks.bggclient.common.NoItemsFoundException;
import co.yellowbricks.bggclient.common.domain.ThingType;
import co.yellowbricks.bggclient.request.BggService;
import co.yellowbricks.bggclient.request.BggServiceException;
import co.yellowbricks.bggclient.search.domain.SearchOutput;

@Service
public class SearchService {
	
	@Inject @Search private Jaxb2Marshaller jaxb2Marshaller;
	@Inject private BggService bgg;

	public SearchOutput search(String query) throws SearchException, NoItemsFoundException {
		try {
			SearchOutput items = (SearchOutput) jaxb2Marshaller.unmarshal(bgg.search(ThingType.BOARDGAME, query));
			
			if (!CollectionUtils.isEmpty(items.getItems()))
				return items;
			throw new NoItemsFoundException();
		} catch (XmlMappingException e) {
			throw new SearchException("searching for " + query, e);
		} catch (BggServiceException e) {
			throw new SearchException("searching for " + query, e);
		}
	}
}
