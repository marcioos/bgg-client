package co.yellowbricks.bggclient.fetch.domain;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import co.yellowbricks.bggclient.BGG;
import co.yellowbricks.bggclient.common.NoItemsFoundException;
import co.yellowbricks.bggclient.fetch.FetchException;

public class FetchItemTest {

    @Test
    public void shouldGetBestNumberOfPlayersForDieMacher() throws FetchException, NoItemsFoundException {
        FetchItem dieMacher = BGG.fetch(1);
        
        Assert.assertThat(dieMacher.getBestNumberOfPlayers(), CoreMatchers.equalTo("5"));
    }
}
