package co.yellowbricks.bggclient.fetch.domain;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

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
	private List<FetchItemName> names;
	
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
	
	@XmlTransient
	private String name;

	@XmlTransient
	private String bestNumberOfPlayers;
	
	@XmlTransient
	private List<String> categories;
	
	@XmlTransient
	private List<String> mechanics;
	
	@XmlTransient
	public String getName() {
	    if (name == null) defineName();
	    return name;
	}
	
	@XmlTransient
	public List<String> getCategories() {
	    if (categories == null) categories = createLinkDataList("boardgamecategory");
	    return categories;
	}

	@XmlTransient
	public List<String> getMechanics() {
	    if (mechanics == null) mechanics = createLinkDataList("boardgamemechanic");
	    return mechanics;
	}

	@XmlTransient
	public String getBestNumberOfPlayers() {
	    if (bestNumberOfPlayers == null) {
    	    if (getSuggestedNumPlayersPoll() == null) bestNumberOfPlayers = "unknown";
    	    else bestNumberOfPlayers = getSuggestedNumPlayersPoll().getNumberOfPlayersWithMostBestVotes();
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
