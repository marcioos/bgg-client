package co.yellowbricks.bggclient.fetch.domain;

import co.yellowbricks.bggclient.BGG;
import co.yellowbricks.bggclient.fetch.FetchException;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FetchItemTest {

    private static final int DIE_MACHER_ID = 1;
    private static final int DOMINION_2004_ID = 64777;

    @Test
    public void shouldGetBestNumberOfPlayersForDieMacher() throws FetchException {
        FetchItem dieMacher = BGG.fetch(Arrays.asList(DIE_MACHER_ID)).iterator().next();

        Assert.assertThat(dieMacher.getBestNumberOfPlayers(), CoreMatchers.equalTo("5"));
    }

    @Test
    public void shouldGetDieMacherCategories() throws FetchException {
        FetchItem dieMacher = BGG.fetch(Arrays.asList(DIE_MACHER_ID)).iterator().next();

        Assert.assertThat(dieMacher.getCategories(), CoreMatchers.equalTo(Arrays.asList("Economic", "Negotiation", "Political")));
    }

    @Test
    public void shouldGetDieMacherMechanics() throws FetchException {
        FetchItem dieMacher = BGG.fetch(Arrays.asList(DIE_MACHER_ID)).iterator().next();

        Assert.assertThat(dieMacher.getMechanics(),
                CoreMatchers.equalTo(Arrays.asList("Area Majority / Influence", "Auction/Bidding", "Dice Rolling", "Hand Management", "Simultaneous Action Selection")));
    }

    @Test
    public void shouldGetDieMacherDesigners() throws FetchException {
        FetchItem dieMacher = BGG.fetch(Arrays.asList(DIE_MACHER_ID)).iterator().next();

        Assert.assertThat(dieMacher.getDesigners(), CoreMatchers.equalTo(Arrays.asList("Karl-Heinz Schmiel")));
    }

    @Test
    public void dominion2004ShouldHaveUnknownBestNumberOfPlayers() throws FetchException {
        FetchItem dominion2004 = BGG.fetch(Arrays.asList(DOMINION_2004_ID)).iterator().next();

        Assert.assertThat(dominion2004.getBestNumberOfPlayers(), CoreMatchers.equalTo("unknown"));
    }
}
