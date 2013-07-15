package co.yellowbricks.bggclient.domain;

import javax.xml.bind.annotation.XmlAttribute;

public class Value {

	@XmlAttribute(name = "value")
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
