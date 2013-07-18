package co.yellowbricks.bggclient.search.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import co.yellowbricks.bggclient.common.domain.Value;

import com.google.common.base.Objects;

public class ThinItem {

	@XmlAttribute(name = "type")
	private String type;
	
	@XmlAttribute(name = "id", required = true)
	private int id;
	
	@XmlElement(name = "name")
	private ThinItemName name;
	
	@XmlElement(name = "yearpublished")
	private Value year;
	
	public String getType() {
		return type;
	}
	
	public int getId() {
		return id;
	}
	
	public ThinItemName getName() {
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
		if (obj instanceof ThinItem) {
			ThinItem that = (ThinItem) obj;
			return Objects.equal(that.name, this.name) && Objects.equal(that.year, this.year)
					&& Objects.equal(that.type, this.type) && Objects.equal(that.id, this.id);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
	public static final class ThinItemName {
		
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
		public String toString() {
			return value;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof ThinItemName) {
				ThinItemName that = (ThinItemName) obj;
				return Objects.equal(that.type, this.type) && Objects.equal(that.value, this.value);
			}
			return false;
		}
	}
}
