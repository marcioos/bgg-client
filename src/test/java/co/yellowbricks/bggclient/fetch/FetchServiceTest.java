package co.yellowbricks.bggclient.fetch;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.yellowbricks.bggclient.common.NoItemsFoundException;
import co.yellowbricks.bggclient.config.SpringContext;
import co.yellowbricks.bggclient.fetch.domain.FetchItem;

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
}
