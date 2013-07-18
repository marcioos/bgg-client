package co.yellowbricks.bggclient.fetch.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class CollectionItem {

	@XmlAttribute(name = "objecttype")
	private String type;
	
	@XmlAttribute(name = "objectid", required = true)
	private int id;
	
	@XmlAttribute(name = "subtype")
	private String subtype;
	
	@XmlAttribute(name = "collid")
	private long collectionId;

	@XmlElement(name = "name")
	private String name;

	@XmlElement(name = "yearpublished")
	private String year;
	
	@XmlElement(name = "image")
	private String imageUrl;
	
	@XmlElement(name = "thumbnail")
	private String thumbnailUrl;
	
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}
	
	public int getId() {
		return id;
	}
	
	public String getSubtype() {
		return subtype;
	}
	
	public long getCollectionId() {
		return collectionId;
	}

	public String getName() {
		return name;
	}
	
	public String getYear() {
		return year;
	}
	public String getImageUrl() {
		return imageUrl;
	}

	public String getType() {
		return type;
	}
}
