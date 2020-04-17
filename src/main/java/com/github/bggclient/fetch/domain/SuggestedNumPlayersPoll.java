package com.github.bggclient.fetch.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.github.bggclient.fetch.domain.Poll.Result;
import com.github.bggclient.fetch.domain.Poll.Results;

public class SuggestedNumPlayersPoll {

    private final Poll poll;

    private String numberOfPlayersWithMostBestVotes;

    public SuggestedNumPlayersPoll(Poll poll) {
        if (!poll.isSuggestedNumPlayersPoll()) {
            throw new IllegalArgumentException("this is not a suggested_numplayers poll");
        }
        this.poll = poll;
    }

    public String getNumberOfPlayersWithMostBestVotes() {
        if (numberOfPlayersWithMostBestVotes == null) {
            calculateSuggestedNumberOfPlayersPollResults();
        }
        return numberOfPlayersWithMostBestVotes;
    }

    private void calculateSuggestedNumberOfPlayersPollResults() {
        Integer maxBestVotes = 0;
        for (Entry<String, Integer> mapEntry : createSuggestedNumPlayersVoteMap().entrySet()) {
            if (mapEntry.getValue() >= maxBestVotes) {
                numberOfPlayersWithMostBestVotes = mapEntry.getKey();
                maxBestVotes = mapEntry.getValue();
            }
        }
    }

    private Map<String, Integer> createSuggestedNumPlayersVoteMap() {
        Map<String, Integer> suggestedNumPlayersVoteMap = new LinkedHashMap<String, Integer>();
        if (poll.getResultsList() == null) {
            return suggestedNumPlayersVoteMap;
        }
        for (Results results : poll.getResultsList()) {
            if (results.getResults() == null) {
                continue;
            }
            for (Result result : results.getResults()) {
                if (result.getValue().equals("Best")) {
                    suggestedNumPlayersVoteMap.put(results.getNumPlayers(), result.getNumVotes());
                    continue;
                }
            }
        }
        return suggestedNumPlayersVoteMap;
    }
}
