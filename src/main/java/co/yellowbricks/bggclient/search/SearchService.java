package co.yellowbricks.bggclient.search;

import javax.inject.Inject;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

import co.yellowbricks.bggclient.common.domain.Thing;
import co.yellowbricks.bggclient.request.BggService;
import co.yellowbricks.bggclient.request.BggServiceException;
import co.yellowbricks.bggclient.search.domain.SearchItems;

@Service
public class SearchService {
	
	@Inject @Search private Jaxb2Marshaller jaxb2Marshaller;
	@Inject private BggService bgg;

	public SearchItems search(String query) throws SearchException {
		try {
			return (SearchItems) jaxb2Marshaller.unmarshal(new StreamSource(bgg.search(Thing.BOARDGAME, query)));
		} catch (XmlMappingException e) {
			throw new SearchException("searching for " + query, e);
		} catch (BggServiceException e) {
			throw new SearchException("searching for " + query, e);
		}
	}
}
