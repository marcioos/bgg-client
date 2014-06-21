package co.yellowbricks.bggclient.fetch.domain;

import java.util.LinkedList;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Transient;

import co.yellowbricks.bggclient.common.domain.Value;

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
	    if (name == null) defineName();
	    return name;
	}

	@Transient
	public List<String> getCategories() {
	    if (categories == null) categories = createLinkDataList("boardgamecategory");
	    return categories;
	}

	@Transient
	public List<String> getMechanics() {
	    if (mechanics == null) mechanics = createLinkDataList("boardgamemechanic");
	    return mechanics;
	}

	@Transient
	public List<String> getDesigners() {
	    if (designers == null) designers = createLinkDataList("boardgamedesigner");
	    return designers;
	}

	@Transient
	public String getBestNumberOfPlayers() {
	    if (bestNumberOfPlayers == null) {
    	    if (getSuggestedNumPlayersPoll() == null) bestNumberOfPlayers = "unknown";
    	    else bestNumberOfPlayers = getSuggestedNumPlayersPoll().getNumberOfPlayersWithMostBestVotes();
    	    if (bestNumberOfPlayers == null) bestNumberOfPlayers = "unknown";
	    }
	    return bestNumberOfPlayers;
	}

    private SuggestedNumPlayersPoll getSuggestedNumPlayersPoll() {
        for (Poll poll : polls) if (poll.isSuggestedNumPlayersPoll()) return poll.asSuggestedNumPlayersPoll();
	    return null;
    }

    private void defineName() {
        for (FetchItemName itemName : names) if (itemName.type.equals("primary")) name = itemName.value;
        if (name == null) name = names.get(0).value;
    }

    private List<String> createLinkDataList(String linkType) {
        List<String> linkDataList = new LinkedList<String>();
        for (Link link : links) if (link.getType().equals(linkType)) linkDataList.add(link.getValue());
        return linkDataList;
    }

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bestNumberOfPlayers == null) ? 0 : bestNumberOfPlayers.hashCode());
        result = prime * result + ((categories == null) ? 0 : categories.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((designers == null) ? 0 : designers.hashCode());
        result = prime * result + id;
        result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
        result = prime * result + ((links == null) ? 0 : links.hashCode());
        result = prime * result + ((maxPlayers == null) ? 0 : maxPlayers.hashCode());
        result = prime * result + ((mechanics == null) ? 0 : mechanics.hashCode());
        result = prime * result + ((minAge == null) ? 0 : minAge.hashCode());
        result = prime * result + ((minPlayers == null) ? 0 : minPlayers.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((names == null) ? 0 : names.hashCode());
        result = prime * result + ((playingTime == null) ? 0 : playingTime.hashCode());
        result = prime * result + ((polls == null) ? 0 : polls.hashCode());
        result = prime * result + ((thumbnailUrl == null) ? 0 : thumbnailUrl.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((year == null) ? 0 : year.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        FetchItem other = (FetchItem) obj;
        if (bestNumberOfPlayers == null) {
            if (other.bestNumberOfPlayers != null) {
                return false;
            }
        } else if (!bestNumberOfPlayers.equals(other.bestNumberOfPlayers)) {
            return false;
        }
        if (categories == null) {
            if (other.categories != null) {
                return false;
            }
        } else if (!categories.equals(other.categories)) {
            return false;
        }
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (designers == null) {
            if (other.designers != null) {
                return false;
            }
        } else if (!designers.equals(other.designers)) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        if (imageUrl == null) {
            if (other.imageUrl != null) {
                return false;
            }
        } else if (!imageUrl.equals(other.imageUrl)) {
            return false;
        }
        if (links == null) {
            if (other.links != null) {
                return false;
            }
        } else if (!links.equals(other.links)) {
            return false;
        }
        if (maxPlayers == null) {
            if (other.maxPlayers != null) {
                return false;
            }
        } else if (!maxPlayers.equals(other.maxPlayers)) {
            return false;
        }
        if (mechanics == null) {
            if (other.mechanics != null) {
                return false;
            }
        } else if (!mechanics.equals(other.mechanics)) {
            return false;
        }
        if (minAge == null) {
            if (other.minAge != null) {
                return false;
            }
        } else if (!minAge.equals(other.minAge)) {
            return false;
        }
        if (minPlayers == null) {
            if (other.minPlayers != null) {
                return false;
            }
        } else if (!minPlayers.equals(other.minPlayers)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (names == null) {
            if (other.names != null) {
                return false;
            }
        } else if (!names.equals(other.names)) {
            return false;
        }
        if (playingTime == null) {
            if (other.playingTime != null) {
                return false;
            }
        } else if (!playingTime.equals(other.playingTime)) {
            return false;
        }
        if (polls == null) {
            if (other.polls != null) {
                return false;
            }
        } else if (!polls.equals(other.polls)) {
            return false;
        }
        if (thumbnailUrl == null) {
            if (other.thumbnailUrl != null) {
                return false;
            }
        } else if (!thumbnailUrl.equals(other.thumbnailUrl)) {
            return false;
        }
        if (type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!type.equals(other.type)) {
            return false;
        }
        if (year == null) {
            if (other.year != null) {
                return false;
            }
        } else if (!year.equals(other.year)) {
            return false;
        }
        return true;
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
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + sortIndex;
            result = prime * result + ((type == null) ? 0 : type.hashCode());
            result = prime * result + ((value == null) ? 0 : value.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            FetchItemName other = (FetchItemName) obj;
            if (sortIndex != other.sortIndex) {
                return false;
            }
            if (type == null) {
                if (other.type != null) {
                    return false;
                }
            } else if (!type.equals(other.type)) {
                return false;
            }
            if (value == null) {
                if (other.value != null) {
                    return false;
                }
            } else if (!value.equals(other.value)) {
                return false;
            }
            return true;
        }
	}
}
