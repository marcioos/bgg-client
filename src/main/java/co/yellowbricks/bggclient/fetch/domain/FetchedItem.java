package co.yellowbricks.bggclient.fetch.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.google.common.base.Objects;

import co.yellowbricks.bggclient.common.domain.Value;

public class FetchedItem {

	@XmlAttribute(name = "type")
	private String type;
	
	@XmlAttribute(name = "id", required = true)
	private int id;
	
	@XmlElement(name = "thumbnail")
	private String thumbnailUrl;
	
	@XmlElement(name = "image")
	private String imageUrl;
	
	@XmlElement(name = "name")
	private FetchedItemName name;
	
	@XmlElement(name = "description")
	private String description;
	
	@XmlElement(name = "yearpublished")
	private Value year;
	
	@XmlElement(name = "minplayers")
	private Value minPlayers;
	
	@XmlElement(name = "maxplayers")
	private Value maxPlayers;
	
	@XmlElement(name = "minage")
	private Value minAge;
	
	@XmlElement(name = "playingtime")
	private Value playingTime;
	
	@XmlElement(name = "poll")
	private List<Poll> polls;
	
	@XmlElement(name = "link")
	private List<Link> links;
	
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

	public FetchedItemName getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Value getYear() {
		return year;
	}

	public Value getMinPlayers() {
		return minPlayers;
	}

	public Value getMaxPlayers() {
		return maxPlayers;
	}

	public Value getMinAge() {
		return minAge;
	}

	public Value getPlayingTime() {
		return playingTime;
	}

	public List<Poll> getPolls() {
		return polls;
	}

	public List<Link> getLinks() {
		return links;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(type, id, thumbnailUrl, imageUrl, name, description, year, minAge, maxPlayers, playingTime, polls, links);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FetchedItem) {
			FetchedItem that = (FetchedItem) obj;
			return Objects.equal(that.type, this.type)
					&& Objects.equal(that.id, this.id)
					&& Objects.equal(that.thumbnailUrl, this.thumbnailUrl)
					&& Objects.equal(that.imageUrl, this.imageUrl)
					&& Objects.equal(that.name, this.name)
					&& Objects.equal(that.description, this.description)
					&& Objects.equal(that.year, this.year)
					&& Objects.equal(that.minAge, this.minAge)
					&& Objects.equal(that.maxPlayers, this.maxPlayers)
					&& Objects.equal(that.playingTime, this.playingTime)
					&& Objects.equal(that.polls, this.polls)
					&& Objects.equal(that.links, this.links);
		}
		return false;
	}

	public static class FetchedItemName {

		@XmlAttribute(name = "type")
		private String type;
		
		@XmlAttribute(name = "sortindex")
		private int sortIndex;
		
		@XmlAttribute(name = "value")
		private String value;
		
		public String getType() {
			return type;
		}

		public int getSortIndex() {
			return sortIndex;
		}

		public String getValue() {
			return value;
		}
		
		@Override
		public int hashCode() {
			return Objects.hashCode(type, sortIndex, value);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof FetchedItemName) {
				FetchedItemName that = (FetchedItemName) obj;
				return Objects.equal(that.type, this.type)
						&& Objects.equal(that.sortIndex, this.sortIndex)
						&& Objects.equal(that.value, this.value);
			}
			return false;
		}
	}
}
