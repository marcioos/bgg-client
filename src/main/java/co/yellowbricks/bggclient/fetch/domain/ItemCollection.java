package co.yellowbricks.bggclient.fetch.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "items")
public class ItemCollection {

	@XmlAttribute(name = "totalitems")
	private int totalItems;
	
	@XmlAttribute(name = "termsofuse")
	private String termsOfUseUrl;
	
	@XmlElement(name = "item")
	private List<CollectionItem> items;
	
	public int getTotalItems() {
		return totalItems;
	}
	
	public String getTermsOfUseUrl() {
		return termsOfUseUrl;
	}
	
	public List<CollectionItem> getItems() {
		return items;
	}
}
