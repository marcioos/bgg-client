package co.yellowbricks.bggclient.fetch.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Objects;

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
	
	@Override
	public int hashCode() {
		return Objects.hashCode(totalItems, termsOfUseUrl, items);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ItemCollection) {
			ItemCollection that = (ItemCollection) obj;
			return Objects.equal(totalItems, that.totalItems)
					&& Objects.equal(termsOfUseUrl, that.termsOfUseUrl)
					&& Objects.equal(items, that.items);
		}
		return false;
	}
}
