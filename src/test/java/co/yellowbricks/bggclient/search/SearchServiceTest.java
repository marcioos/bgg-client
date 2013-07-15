package co.yellowbricks.bggclient.search;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import co.yellowbricks.bggclient.search.domain.SearchedItems;

public class SearchServiceTest {

	private SearchService searchService = new SearchService();
	
	@Test
	public void test() throws SearchException {
		SearchedItems items = searchService.search("dominion");
		
		Assert.assertThat(items.getTotal(), CoreMatchers.is(27));
	}
}
