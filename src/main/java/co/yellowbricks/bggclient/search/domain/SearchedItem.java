package co.yellowbricks.bggclient.search.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import co.yellowbricks.bggclient.common.domain.Value;

import com.google.common.base.Objects;

public class SearchedItem {

	@XmlElement(name = "name")
	private SearchedItemName name;
	
	@XmlElement(name = "yearpublished")
	private Value year;
	
	public SearchedItemName getName() {
		return name;
	}
	
	public Value getYear() {
		return year;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(name, year);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SearchedItem) {
			SearchedItem that = (SearchedItem) obj;
			return Objects.equal(that.name, this.name) && Objects.equal(that.year, this.year);
		}
		return false;
	}
	
	public static final class SearchedItemName {
		
		@XmlAttribute(name = "type")
		private String type;
		
		@XmlAttribute(name = "value")
		private String value;
		
		public String getType() {
			return type;
		}
		
		public String getValue() {
			return value;
		}
		
		@Override
		public int hashCode() {
			return Objects.hashCode(type, value);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof SearchedItemName) {
				SearchedItemName that = (SearchedItemName) obj;
				return Objects.equal(that.type, this.type) && Objects.equal(that.value, this.value);
			}
			return false;
		}
	}
}
