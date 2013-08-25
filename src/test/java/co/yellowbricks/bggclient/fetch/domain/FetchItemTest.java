package co.yellowbricks.bggclient.fetch.domain;

import java.util.Arrays;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import co.yellowbricks.bggclient.BGG;
import co.yellowbricks.bggclient.common.NoItemsFoundException;
import co.yellowbricks.bggclient.fetch.FetchException;

public class FetchItemTest {

    private static final int DIE_MACHER_ID = 1;
    private static final int DOMINION_2004_ID = 64777;

    @Test
    public void shouldGetBestNumberOfPlayersForDieMacher() throws FetchException, NoItemsFoundException {
        FetchItem dieMacher = BGG.fetch(DIE_MACHER_ID);
        
        Assert.assertThat(dieMacher.getBestNumberOfPlayers(), CoreMatchers.equalTo("5"));
    }
    
    @Test
    public void shouldGetDieMacherCategories() throws FetchException, NoItemsFoundException {
        FetchItem dieMacher = BGG.fetch(DIE_MACHER_ID);
        
        Assert.assertThat(dieMacher.getCategories(), CoreMatchers.equalTo(Arrays.asList("Economic", "Political")));
    }
    
    @Test
    public void shouldGetDieMacherMechanics() throws FetchException, NoItemsFoundException {
        FetchItem dieMacher = BGG.fetch(DIE_MACHER_ID);
        
        Assert.assertThat(dieMacher.getMechanics(), CoreMatchers.equalTo(Arrays.asList("Auction/Bidding")));
    }
    
    @Test
    public void shouldGetDieMacherDesigners() throws FetchException, NoItemsFoundException {
        FetchItem dieMacher = BGG.fetch(DIE_MACHER_ID);
        
        Assert.assertThat(dieMacher.getDesigners(), CoreMatchers.equalTo(Arrays.asList("Karl-Heinz Schmiel")));
    }
    
    @Test
    public void dominion2004ShouldHaveUnknownBestNumberOfPlayers() throws FetchException, NoItemsFoundException {
        FetchItem dominion2004 = BGG.fetch(DOMINION_2004_ID);
        
        Assert.assertThat(dominion2004.getBestNumberOfPlayers(), CoreMatchers.equalTo("unknown"));
    }
}
