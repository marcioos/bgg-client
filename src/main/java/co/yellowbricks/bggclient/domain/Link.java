package co.yellowbricks.bggclient.domain;

import javax.xml.bind.annotation.XmlAttribute;

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
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
