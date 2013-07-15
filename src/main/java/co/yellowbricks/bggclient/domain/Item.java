package co.yellowbricks.bggclient.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


public class Item {

	@XmlAttribute(name = "type")
	private String type;
	
	@XmlAttribute(name = "id")
	private int id;
	
	@XmlElement(name = "thumbnail")
	private String thumbnailUrl;
	
	@XmlElement(name = "image")
	private String imageUrl;
	
	@XmlElement(name = "name")
	private Name name;
	
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

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Value getYear() {
		return year;
	}

	public void setYear(Value year) {
		this.year = year;
	}

	public Value getMinPlayers() {
		return minPlayers;
	}

	public void setMinPlayers(Value minPlayers) {
		this.minPlayers = minPlayers;
	}

	public Value getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(Value maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public Value getMinAge() {
		return minAge;
	}

	public void setMinAge(Value minAge) {
		this.minAge = minAge;
	}

	public Value getPlayingTime() {
		return playingTime;
	}

	public void setPlayingTime(Value playingTime) {
		this.playingTime = playingTime;
	}

	public List<Poll> getPolls() {
		return polls;
	}

	public void setPolls(List<Poll> polls) {
		this.polls = polls;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public static class Name {

		@XmlAttribute(name = "type")
		private String type;
		
		@XmlAttribute(name = "sortindex")
		private int sortIndex;
		
		@XmlAttribute(name = "value")
		private String value;
		
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public int getSortIndex() {
			return sortIndex;
		}

		public void setSortIndex(int sortIndex) {
			this.sortIndex = sortIndex;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
}
