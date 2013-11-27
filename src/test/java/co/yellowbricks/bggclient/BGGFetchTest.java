package co.yellowbricks.bggclient;

import co.yellowbricks.bggclient.common.NoItemsFoundException;
import co.yellowbricks.bggclient.common.ThingType;
import co.yellowbricks.bggclient.fetch.FetchException;
import co.yellowbricks.bggclient.fetch.domain.CollectionItem;
import co.yellowbricks.bggclient.fetch.domain.FetchItem;
import co.yellowbricks.bggclient.fetch.domain.UserCollection;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class BGGFetchTest {

    @Test
    public void shouldFetchDieMacher() throws FetchException, NoItemsFoundException {
        int dieMacherId = 1;
        
        FetchItem item = BGG.fetch(dieMacherId, ThingType.BOARDGAME);

        assertThat(item.getName(), containsString("Macher"));
    }
    
   @Test
    public void shouldFetchAgricolaXDeck() throws FetchException, NoItemsFoundException {
        int agricolaXDeckId = 38733;
        
        FetchItem item = BGG.fetch(agricolaXDeckId, ThingType.BOARDGAME_EXPANSION);

        assertThat(item.getName(), containsString("Agricola"));
    }
    
    @Test(expected = NoItemsFoundException.class)
    public void shouldFindNoItems() throws FetchException, NoItemsFoundException {
        BGG.fetch(13123123);
    }
    
    @Test
    public void shouldFetchMyCollection() throws FetchException, NoItemsFoundException {
        String myName = "marcio_os";
        
        UserCollection myCollection = BGG.fetchCollection(myName);
        
        assertThat(myCollection.getTotalItems(), is(13));
    }
    
    @Test
    public void collectionShouldContainBGGTermsOfUseUrl() throws FetchException, NoItemsFoundException {
        String myName = "marcio_os";
        
        UserCollection myCollection = BGG.fetchCollection(myName);
        
        assertThat(myCollection.getTermsOfUseUrl(), is("http://boardgamegeek.com/xmlapi/termsofuse"));
    }
    
    @Test
    public void myCollectionShouldContainDominion() throws FetchException, NoItemsFoundException {
        String myName = "marcio_os";
        
        UserCollection myCollection = BGG.fetchCollection(myName);
        
        for (CollectionItem item : myCollection.getItems()) if ("Dominion".equals(item.getName())) return;
        fail("Dominion not found");
    }
}
