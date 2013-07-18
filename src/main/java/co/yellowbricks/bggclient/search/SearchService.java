package co.yellowbricks.bggclient.search;

import javax.inject.Inject;

import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import co.yellowbricks.bggclient.common.NoItemsFoundException;
import co.yellowbricks.bggclient.common.domain.Thing;
import co.yellowbricks.bggclient.request.BggService;
import co.yellowbricks.bggclient.request.BggServiceException;
import co.yellowbricks.bggclient.search.domain.SearchItems;

@Service
public class SearchService {
	
	@Inject @Search private Jaxb2Marshaller jaxb2Marshaller;
	@Inject private BggService bgg;

	public SearchItems search(String query) throws SearchException, NoItemsFoundException {
		try {
			SearchItems items = (SearchItems) jaxb2Marshaller.unmarshal(bgg.search(Thing.BOARDGAME, query));
			
			if (!CollectionUtils.isEmpty(items.getItems())) {
				return items;
			}
			throw new NoItemsFoundException();
		} catch (XmlMappingException e) {
			throw new SearchException("searching for " + query, e);
		} catch (BggServiceException e) {
			throw new SearchException("searching for " + query, e);
		}
	}
}
