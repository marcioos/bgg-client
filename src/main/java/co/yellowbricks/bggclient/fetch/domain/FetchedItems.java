package co.yellowbricks.bggclient.fetch.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Objects;

@XmlRootElement(name = "items")
public class FetchedItems {

	@XmlAttribute(name = "termsofuse")
	private String termsOfUseUrl;
	
	@XmlElement(name = "item")
	private List<FetchedItem> items;
	
	public String getTermsOfUseUrl() {
		return termsOfUseUrl;
	}
	
	public List<FetchedItem> getItems() {
		return items;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(termsOfUseUrl, items);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FetchedItems) {
			FetchedItems that = (FetchedItems) obj;
			return Objects.equal(that.getItems(), this.items)
					&& Objects.equal(that.getTermsOfUseUrl(), this.getTermsOfUseUrl());
		}
		return false;
	}
}
