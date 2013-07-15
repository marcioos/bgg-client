package co.yellowbricks.bggclient.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "items")
public class Items {

	@XmlAttribute(name = "termsofuse")
	private String termsOfUseUrl;
	
	@XmlElement(name = "item")
	private List<Item> items;
	
	public String getTermsOfUseUrl() {
		return termsOfUseUrl;
	}
	
	public void setTermsOfUseUrl(String termsOfUseUrl) {
		this.termsOfUseUrl = termsOfUseUrl;
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}
}
