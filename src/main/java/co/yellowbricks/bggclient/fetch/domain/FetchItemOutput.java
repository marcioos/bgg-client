package co.yellowbricks.bggclient.fetch.domain;

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
public class FetchItemOutput {

	public static final Unmarshaller UNMARSHALLER = JAXB.createUnmarshaller(FetchItemOutput.class);

    @XmlAttribute(name = "termsofuse")
	private String termsOfUseUrl;
	
	@XmlElement(name = "item")
	private List<FetchItem> items;
}
