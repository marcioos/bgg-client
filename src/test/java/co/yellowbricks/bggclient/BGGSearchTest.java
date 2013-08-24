package co.yellowbricks.bggclient;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import co.yellowbricks.bggclient.common.NoItemsFoundException;
import co.yellowbricks.bggclient.search.SearchException;
import co.yellowbricks.bggclient.search.domain.SearchOutput;

public class BGGSearchTest {

    @Test
    public void shouldReturnCorrectAmountOfDominionGames() throws SearchException, NoItemsFoundException {
        SearchOutput items = BGG.search("dominion");

        Assert.assertThat(items.getTotal(), CoreMatchers.is(67));
    }

    @Test(expected = NoItemsFoundException.class)
    public void shouldFindNoItems() throws SearchException, NoItemsFoundException {
        BGG.search("a game that should not exist");
    }
}
