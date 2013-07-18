package co.yellowbricks.bggclient.fetch.domain;

import javax.xml.bind.annotation.XmlAttribute;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.google.common.base.Objects;

public class Link {

	@XmlAttribute(name = "type")
	private String type;
	
	@XmlAttribute(name = "id")
	private int id;
	
	@XmlAttribute(name = "value")
	private String value;
	
	public String getType() {
		return type;
	}
	
	public int getId() {
		return id;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(type, id, value);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Link) {
			Link that = (Link) obj;
			return Objects.equal(that.type, this.type)
					&& Objects.equal(that.id, this.id)
					&& Objects.equal(that.value, this.value);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
