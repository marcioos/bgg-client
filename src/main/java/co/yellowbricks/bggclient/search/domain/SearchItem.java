package co.yellowbricks.bggclient.search.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import co.yellowbricks.bggclient.common.domain.Value;

@Getter @EqualsAndHashCode @ToString
public class SearchItem {

	@XmlAttribute(name = "type")
	private String type;
	
	@XmlAttribute(name = "id", required = true)
	private int id;
	
	@XmlElement(name = "name")
	private SearchItemName name;
	
	@XmlElement(name = "yearpublished")
	private Value year;
	
	@Getter @EqualsAndHashCode @ToString
	public static final class SearchItemName {
		
		@XmlAttribute(name = "type")
		private String type;
		
		@XmlAttribute(name = "value")
		private String value;
	}
}
