package co.yellowbricks.bggclient.fetch.domain;

import java.util.List;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import co.yellowbricks.bggclient.common.JAXB;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter @EqualsAndHashCode @ToString
@XmlRootElement(name = "items")
public class UserCollection {

	public static final Unmarshaller UNMARSHALLER = JAXB.createUnmarshaller(UserCollection.class);

    @XmlAttribute(name = "totalitems")
	private int totalItems;
	
	@XmlAttribute(name = "termsofuse")
	private String termsOfUseUrl;
	
	@XmlElement(name = "item")
	private List<CollectionItem> items;
}
