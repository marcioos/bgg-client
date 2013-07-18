package co.yellowbricks.bggclient;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import co.yellowbricks.bggclient.BGG;

public class BGGTest {

	@Test
	public void shouldGetSearchService() {
		assertNotNull(BGG.getSearchService());
	}
	
	@Test
	public void shouldGetFetchService() {
		assertNotNull(BGG.getFetchService());
	}

}
