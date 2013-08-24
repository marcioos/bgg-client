package co.yellowbricks.bggclient.search.domain;

import java.util.List;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import co.yellowbricks.bggclient.common.JAXB;

@Getter @EqualsAndHashCode @ToString
@XmlRootElement(name = "items")
public class SearchOutput {
    
    public static final Unmarshaller UNMARSHALLER = JAXB.createUnmarshaller(SearchOutput.class);
	
	@XmlAttribute(name = "total")
	private int total;

	@XmlAttribute(name = "termsofuse")
	private String termsOfUseUrl;
	
	@XmlElement(name = "item")
	private List<SearchItem> items;	
}
