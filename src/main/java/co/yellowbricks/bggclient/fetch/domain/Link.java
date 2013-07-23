package co.yellowbricks.bggclient.fetch.domain;

import javax.xml.bind.annotation.XmlAttribute;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter @EqualsAndHashCode @ToString
public class Link {

	@XmlAttribute(name = "type")
	private String type;
	
	@XmlAttribute(name = "id")
	private int id;
	
	@XmlAttribute(name = "value")
	private String value;
}
