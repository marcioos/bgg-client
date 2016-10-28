package co.yellowbricks.bggclient;

import co.yellowbricks.bggclient.common.ThingType;
import co.yellowbricks.bggclient.search.SearchException;
import co.yellowbricks.bggclient.search.domain.SearchItem;
import co.yellowbricks.bggclient.search.domain.SearchOutput;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class BGGSearchTest {

    @Test
    public void shouldReturnCorrectAmountOfDominionGames() throws SearchException {
        SearchOutput items = BGG.search("dominion", ThingType.BOARDGAME).get();

        assertThat(items.getTotal(), is(52));
    }

    public void shouldFindNoItems() throws SearchException {
        assertThat(BGG.search("a game that should not exist"), is(Optional.empty()));
    }

    @Test
    public void searchBoardgamesShouldReturnExpansion() throws SearchException {
        int agricolaXDeckId = 38733;

        SearchOutput items = BGG.search("agricola", ThingType.BOARDGAME).get();

        for (SearchItem item : items.getItems()) {
            if (item.getId() == agricolaXDeckId) {
                return;
            }
        }
        fail("SearchOutput does not contain Agricola X-Deck id");
    }
}
