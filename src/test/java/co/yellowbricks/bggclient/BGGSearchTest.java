package co.yellowbricks.bggclient;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import co.yellowbricks.bggclient.common.NoItemsFoundException;
import co.yellowbricks.bggclient.common.ThingType;
import co.yellowbricks.bggclient.search.SearchException;
import co.yellowbricks.bggclient.search.domain.SearchItem;
import co.yellowbricks.bggclient.search.domain.SearchOutput;

public class BGGSearchTest {

    @Test
    public void shouldReturnCorrectAmountOfDominionGames() throws SearchException, NoItemsFoundException {
        SearchOutput items = BGG.search("dominion", ThingType.BOARDGAME);

        Assert.assertThat(items.getTotal(), CoreMatchers.is(28));
    }

    @Test(expected = NoItemsFoundException.class)
    public void shouldFindNoItems() throws SearchException, NoItemsFoundException {
        BGG.search("a game that should not exist");
    }
    
    @Test
    public void searchBoardgamesShouldReturnExpansion() throws SearchException, NoItemsFoundException {
        int agricolaXDeckId = 38733;
        
        SearchOutput items = BGG.search("agricola", ThingType.BOARDGAME);
        
        for (SearchItem item : items.getItems()) if (item.getId() == agricolaXDeckId) return;
        Assert.fail("SearchOutput does not contain Agricola X-Deck id");
    }
}
