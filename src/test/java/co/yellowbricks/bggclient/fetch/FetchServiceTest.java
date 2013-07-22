
package co.yellowbricks.bggclient.fetch;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.yellowbricks.bggclient.common.NoItemsFoundException;
import co.yellowbricks.bggclient.config.SpringContext;
import co.yellowbricks.bggclient.fetch.domain.CollectionItem;
import co.yellowbricks.bggclient.fetch.domain.FetchItem;
import co.yellowbricks.bggclient.fetch.domain.UserCollection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContext.class)
public class FetchServiceTest {

	@Inject private FetchService fetchService;
	
	@Test
	public void shouldFetchDieMacher() throws FetchException, NoItemsFoundException {
		int dieMacherId = 1;
		
		FetchItem item = fetchService.fetch(dieMacherId);

		assertThat(item.getName().getValue(), containsString("Macher"));
	}
	
	@Test(expected = NoItemsFoundException.class)
	public void shouldFindNoItems() throws FetchException, NoItemsFoundException {
		fetchService.fetch(13123123);
	}
	
	@Test
	public void shouldFetchMyCollection() throws FetchException, NoItemsFoundException {
		String myName = "marcio_os";
		
		UserCollection myCollection = fetchService.fetchCollection(myName);
		
		assertThat(myCollection.getTotalItems(), is(18));
	}
	
	@Test
	public void collectionShouldContainBGGTermsOfUseUrl() throws FetchException, NoItemsFoundException {
		String myName = "marcio_os";
		
		UserCollection myCollection = fetchService.fetchCollection(myName);
		
		assertThat(myCollection.getTermsOfUseUrl(), is("http://boardgamegeek.com/xmlapi/termsofuse"));
	}
	
	@Test
	public void myCollectionShouldContainDominion() throws FetchException, NoItemsFoundException {
		String myName = "marcio_os";
		
		UserCollection myCollection = fetchService.fetchCollection(myName);
		
		for (CollectionItem item : myCollection.getItems()) if ("Dominion".equals(item.getName())) return;
		fail("Dominion not found");
	}
}
