package co.yellowbricks.bggclient;

import co.yellowbricks.bggclient.common.ThingType;
import co.yellowbricks.bggclient.fetch.FetchException;
import co.yellowbricks.bggclient.fetch.domain.CollectionItem;
import co.yellowbricks.bggclient.fetch.domain.FetchItem;
import co.yellowbricks.bggclient.fetch.domain.UserCollection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class BGGFetchTest {

    @Test
    public void shouldFetchDieMacher() throws FetchException {
        int dieMacherId = 1;

        FetchItem item = BGG.fetch(Arrays.asList(dieMacherId), ThingType.BOARDGAME).iterator().next();

        assertThat(item.getName(), containsString("Macher"));
    }

    @Test
    public void shouldFetchAgricolaXDeck() throws FetchException {
        int agricolaXDeckId = 38733;

        FetchItem item = BGG.fetch(Arrays.asList(agricolaXDeckId), ThingType.BOARDGAME_EXPANSION).iterator().next();

        assertThat(item.getName(), containsString("Agricola"));
    }

    @Test
    public void shouldFetchAgricolaXDeckAndDieMacher() throws FetchException {
        int agricolaXDeckId = 38733;
        int dieMacherId = 1;

        Collection<FetchItem> item = BGG.fetch(Arrays.asList(agricolaXDeckId, dieMacherId));

        assertThat(((ArrayList<FetchItem>) item).get(0).getName(), containsString("Agricola"));
        assertThat(((ArrayList<FetchItem>) item).get(1).getName(), containsString("Macher"));
    }

    @Test(expected = FetchException.class)
    public void shouldFindNoItems() throws FetchException {
        BGG.fetch(Arrays.asList(13123123, 2380182));
    }

    @Test
    public void shouldFetchMyCollection() throws FetchException {
        String myName = "marcio_os";

        UserCollection myCollection = BGG.fetchCollection(myName).get();

        assertThat(myCollection.getTotalItems(), is(not(0)));
    }

    @Test
    public void collectionShouldContainBGGTermsOfUseUrl() throws FetchException {
        String myName = "marcio_os";

        UserCollection myCollection = BGG.fetchCollection(myName).get();

        assertThat(myCollection.getTermsOfUseUrl(), is("http://boardgamegeek.com/xmlapi/termsofuse"));
    }

    @Test
    public void myCollectionShouldContainDominion() throws FetchException {
        String myName = "marcio_os";

        UserCollection myCollection = BGG.fetchCollection(myName).get();

        for (CollectionItem item : myCollection.getItems()) if ("Dominion".equals(item.getName())) return;
        fail("Dominion not found");
    }
}
