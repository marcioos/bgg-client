package co.yellowbricks.bggclient.fetch.domain;

import java.util.List;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import co.yellowbricks.bggclient.common.JAXB;

@XmlRootElement(name = "items")
public class UserCollection {

	public static final Unmarshaller UNMARSHALLER = JAXB.createUnmarshaller(UserCollection.class);

    @XmlAttribute(name = "totalitems")
	private int totalItems;

	@XmlAttribute(name = "termsofuse")
	private String termsOfUseUrl;

	@XmlElement(name = "item")
	private List<CollectionItem> items;

	public int getTotalItems() {
        return totalItems;
    }

	public String getTermsOfUseUrl() {
        return termsOfUseUrl;
    }

	public List<CollectionItem> getItems() {
        return items;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((items == null) ? 0 : items.hashCode());
        result = prime * result + ((termsOfUseUrl == null) ? 0 : termsOfUseUrl.hashCode());
        result = prime * result + totalItems;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UserCollection other = (UserCollection) obj;
        if (items == null) {
            if (other.items != null) {
                return false;
            }
        } else if (!items.equals(other.items)) {
            return false;
        }
        if (termsOfUseUrl == null) {
            if (other.termsOfUseUrl != null) {
                return false;
            }
        } else if (!termsOfUseUrl.equals(other.termsOfUseUrl)) {
            return false;
        }
        if (totalItems != other.totalItems) {
            return false;
        }
        return true;
    }
}
