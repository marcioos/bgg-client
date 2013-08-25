package co.yellowbricks.bggclient.fetch.domain;

import java.util.Arrays;

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
    
    @Test
    public void shouldGetDieMacherCategories() throws FetchException, NoItemsFoundException {
        FetchItem dieMacher = BGG.fetch(1);
        
        Assert.assertThat(dieMacher.getCategories(), CoreMatchers.equalTo(Arrays.asList("Economic", "Political")));
    }
    
    @Test
    public void shouldGetDieMacherMechanics() throws FetchException, NoItemsFoundException {
        FetchItem dieMacher = BGG.fetch(1);
        
        Assert.assertThat(dieMacher.getMechanics(), CoreMatchers.equalTo(Arrays.asList("Auction/Bidding")));
    }
}
