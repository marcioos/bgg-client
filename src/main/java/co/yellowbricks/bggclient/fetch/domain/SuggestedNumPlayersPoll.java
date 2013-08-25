package co.yellowbricks.bggclient.fetch.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import co.yellowbricks.bggclient.fetch.domain.Poll.Result;
import co.yellowbricks.bggclient.fetch.domain.Poll.Results;

public class SuggestedNumPlayersPoll {

    private final Poll poll;

    private String numberOfPlayersWithMostBestVotes;
    private String numberOfPlayersWithMostNotRecommendedVotes;

    public SuggestedNumPlayersPoll(Poll poll) {
        if (!poll.isSuggestedNumPlayersPoll()) throw new IllegalArgumentException("this is not a suggested_numplayers poll");
        this.poll = poll;
    }
    
    public String getNumberOfPlayersWithMostBestVotes() {
        if (numberOfPlayersWithMostBestVotes == null) calculateSuggestedNumberOfPlayersPollResults();
        return numberOfPlayersWithMostBestVotes;
    }

    public String getNumberOfPlayersWithMostNotRecommendedVotes() {
        if (numberOfPlayersWithMostNotRecommendedVotes == null) calculateSuggestedNumberOfPlayersPollResults();
        return numberOfPlayersWithMostNotRecommendedVotes;
    }

    private void calculateSuggestedNumberOfPlayersPollResults() {
        Integer maxBestVotes = 0;
        Integer maxNotRecommendedVotes = 0;
        for (Entry<String, NumPlayerVotes> mapEntry : createSuggestedNumPlayersVoteMap().entrySet()) {
            if (mapEntry.getValue().best >= maxBestVotes) {
                numberOfPlayersWithMostBestVotes = mapEntry.getKey();
                maxBestVotes = mapEntry.getValue().best;
            }
            if (mapEntry.getValue().notRecommended >= maxNotRecommendedVotes) {
                numberOfPlayersWithMostNotRecommendedVotes = mapEntry.getKey();
                maxNotRecommendedVotes = mapEntry.getValue().notRecommended;
            }
        }
    }

    private Map<String, NumPlayerVotes> createSuggestedNumPlayersVoteMap() {
        Map<String, NumPlayerVotes> suggestedNumPlayersVoteMap = new LinkedHashMap<String, NumPlayerVotes>();
        for (Results results : poll.getResultsList()) {
            NumPlayerVotes numPlayerVotes = new NumPlayerVotes();
            for (Result result : results.getResults()) {
                if (result.getValue().equals("Best")) numPlayerVotes.best = result.getNumVotes();
                if (result.getValue().equals("Not Recommended")) numPlayerVotes.notRecommended = result.getNumVotes();
            }
            suggestedNumPlayersVoteMap.put(results.getNumPlayers(), numPlayerVotes);
        }
        return suggestedNumPlayersVoteMap;
    }
    
    private static final class NumPlayerVotes {
        Integer notRecommended = 0;
        Integer best = 0;
    }
}
