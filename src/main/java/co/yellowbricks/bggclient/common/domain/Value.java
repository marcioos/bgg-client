package co.yellowbricks.bggclient.common.domain;

import javax.xml.bind.annotation.XmlAttribute;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter @EqualsAndHashCode @ToString
public class Value {

	@XmlAttribute(name = "value")
	private String value;
}
