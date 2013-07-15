package co.yellowbricks.bggclient.common.domain;

import javax.xml.bind.annotation.XmlAttribute;

import com.google.common.base.Objects;

public class Value {

	@XmlAttribute(name = "value")
	private String value;

	public String getValue() {
		return value;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(value);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Value) {
			Value that = (Value) obj;
			return Objects.equal(this.value, that.value);
		}
		return false;
	}
}
