package co.yellowbricks.bggclient;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import co.yellowbricks.bggclient.common.NoItemsFoundException;
import co.yellowbricks.bggclient.common.ThingType;
import co.yellowbricks.bggclient.fetch.FetchException;
import co.yellowbricks.bggclient.fetch.domain.CollectionItem;
import co.yellowbricks.bggclient.fetch.domain.FetchItem;
import co.yellowbricks.bggclient.fetch.domain.UserCollection;

public class BGGFetchTest {

    @Test
    public void shouldFetchDieMacher() throws FetchException, NoItemsFoundException {
        int dieMacherId = 1;

        FetchItem item = BGG.fetch(Arrays.asList(dieMacherId), ThingType.BOARDGAME).iterator().next();

        assertThat(item.getName(), containsString("Macher"));
    }

    @Test
    public void shouldFetchAgricolaXDeck() throws FetchException, NoItemsFoundException {
        int agricolaXDeckId = 38733;

        FetchItem item = BGG.fetch(Arrays.asList(agricolaXDeckId), ThingType.BOARDGAME_EXPANSION).iterator().next();

        assertThat(item.getName(), containsString("Agricola"));
    }

    @Test
    public void shouldFetchAgricolaXDeckAndDieMacher() throws FetchException, NoItemsFoundException {
        int agricolaXDeckId = 38733;
        int dieMacherId = 1;

        Collection<FetchItem> item = BGG.fetch(Arrays.asList(agricolaXDeckId, dieMacherId));

        assertThat(((ArrayList<FetchItem>) item).get(0).getName(), containsString("Agricola"));
        assertThat(((ArrayList<FetchItem>) item).get(1).getName(), containsString("Macher"));
    }

    @Test(expected = NoItemsFoundException.class)
    public void shouldFindNoItems() throws FetchException, NoItemsFoundException {
        BGG.fetch(Arrays.asList(13123123, 2380182));
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

    @Test
    public void fetchBevatronCollection() throws FetchException, NoItemsFoundException {
        String userName = "bevatron";

        UserCollection collection = BGG.fetchCollection(userName);
    }
}
