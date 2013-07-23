package co.yellowbricks.bggclient.fetch.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import co.yellowbricks.bggclient.common.domain.Value;

@Getter @EqualsAndHashCode @ToString
public class FetchItem {

	@XmlAttribute(name = "type")
	private String type;
	
	@XmlAttribute(name = "id", required = true)
	private int id;
	
	@XmlElement(name = "thumbnail")
	private String thumbnailUrl;
	
	@XmlElement(name = "image")
	private String imageUrl;
	
	@XmlElement(name = "name")
	private FetchItemName name;
	
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
		
	@Getter @EqualsAndHashCode
	public static class FetchItemName {

		@XmlAttribute(name = "type")
		private String type;
		
		@XmlAttribute(name = "sortindex")
		private int sortIndex;
		
		@XmlAttribute(name = "value")
		private String value;
							
		@Override
		public String toString() {
			return value;
		}
	}
}
