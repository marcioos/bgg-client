package com.github.bggclient.fetch.domain;

import com.github.bggclient.common.domain.Value;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Transient;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Root(name = "item", strict = false)
public class FetchItem {

    @Attribute(name = "type", required = false)
    private String type;

    @Attribute(name = "id", required = true)
    private int id;

    @Element(name = "thumbnail", required = false)
    private String thumbnailUrl;

    @Element(name = "image", required = false)
    private String imageUrl;

    @ElementList(entry = "name", required = false, inline = true)
    private List<FetchItemName> names;

    @Element(name = "description", required = false)
    private String description;

    @Element(name = "yearpublished", required = false)
    private Value year;

    @Element(name = "minplayers", required = false)
    private Value minPlayers;

    @Element(name = "maxplayers", required = false)
    private Value maxPlayers;

    @Element(name = "minage", required = false)
    private Value minAge;

    @Element(name = "playingtime", required = false)
    private Value playingTime;

    @ElementList(entry = "poll", inline = true, required = false)
    private List<Poll> polls;

    @ElementList(entry = "link", inline = true, required = false)
    private List<Link> links;

    @Transient
    private String name;

    @Transient
    private String bestNumberOfPlayers;

    @Transient
    private List<String> categories;

    @Transient
    private List<String> mechanics;

    @Transient
    private List<String> designers;

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<FetchItemName> getNames() {
        return names;
    }

    public String getDescription() {
        return description;
    }

    public Value getYear() {
        return year;
    }

    public Value getMinAge() {
        return minAge;
    }

    public Value getMinPlayers() {
        return minPlayers;
    }

    public List<Link> getLinks() {
        return links;
    }

    public Value getMaxPlayers() {
        return maxPlayers;
    }

    public Value getPlayingTime() {
        return playingTime;
    }

    public List<Poll> getPolls() {
        return polls;
    }

    @Transient
    public String getName() {
        if (name == null) {
            defineName();
        }
        return name;
    }

    @Transient
    public List<String> getCategories() {
        if (categories == null) {
            categories = createLinkDataList("boardgamecategory");
        }
        return categories;
    }

    @Transient
    public List<String> getMechanics() {
        if (mechanics == null) {
            mechanics = createLinkDataList("boardgamemechanic");
        }
        return mechanics;
    }

    @Transient
    public List<String> getDesigners() {
        if (designers == null) {
            designers = createLinkDataList("boardgamedesigner");
        }
        return designers;
    }

    @Transient
    public String getBestNumberOfPlayers() {
        if (bestNumberOfPlayers == null) {
            if (getSuggestedNumPlayersPoll() == null) {
                bestNumberOfPlayers = "unknown";
            } else {
                bestNumberOfPlayers = getSuggestedNumPlayersPoll().getNumberOfPlayersWithMostBestVotes();
            }
            if (bestNumberOfPlayers == null) {
                bestNumberOfPlayers = "unknown";
            }
        }
        return bestNumberOfPlayers;
    }

    private SuggestedNumPlayersPoll getSuggestedNumPlayersPoll() {
        for (Poll poll : polls) {
            if (poll.isSuggestedNumPlayersPoll()) {
                return poll.asSuggestedNumPlayersPoll();
            }
        }
        return null;
    }

    private void defineName() {
        for (FetchItemName itemName : names) {
            if (itemName.type.equals("primary")) {
                name = itemName.value;
            }
        }
        if (name == null) {
            name = names.get(0).value;
        }
    }

    private List<String> createLinkDataList(String linkType) {
        List<String> linkDataList = new LinkedList<String>();
        for (Link link : links) {
            if (link.getType().equals(linkType)) {
                linkDataList.add(link.getValue());
            }
        }
        return linkDataList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FetchItem fetchItem = (FetchItem) o;
        return id == fetchItem.id &&
                Objects.equals(type, fetchItem.type) &&
                Objects.equals(thumbnailUrl, fetchItem.thumbnailUrl) &&
                Objects.equals(imageUrl, fetchItem.imageUrl) &&
                Objects.equals(names, fetchItem.names) &&
                Objects.equals(description, fetchItem.description) &&
                Objects.equals(year, fetchItem.year) &&
                Objects.equals(minPlayers, fetchItem.minPlayers) &&
                Objects.equals(maxPlayers, fetchItem.maxPlayers) &&
                Objects.equals(minAge, fetchItem.minAge) &&
                Objects.equals(playingTime, fetchItem.playingTime) &&
                Objects.equals(polls, fetchItem.polls) &&
                Objects.equals(links, fetchItem.links) &&
                Objects.equals(name, fetchItem.name) &&
                Objects.equals(bestNumberOfPlayers, fetchItem.bestNumberOfPlayers) &&
                Objects.equals(categories, fetchItem.categories) &&
                Objects.equals(mechanics, fetchItem.mechanics) &&
                Objects.equals(designers, fetchItem.designers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, thumbnailUrl, imageUrl, names, description, year, minPlayers,
                            maxPlayers, minAge, playingTime, polls, links, name, bestNumberOfPlayers,
                            categories, mechanics, designers);
    }

    public static class FetchItemName {

        @Attribute(name = "type", required = false)
        private String type;

        @Attribute(name = "sortindex", required = false)
        private int sortIndex;

        @Attribute(name = "value", required = false)
        private String value;

        @Override
        public String toString() {
            return value;
        }

        public int getSortIndex() {
            return sortIndex;
        }

        public String getType() {
            return type;
        }

        public String getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            FetchItemName that = (FetchItemName) o;
            return sortIndex == that.sortIndex &&
                    Objects.equals(type, that.type) &&
                    Objects.equals(value, that.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type, sortIndex, value);
        }
    }
}
