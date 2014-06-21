package co.yellowbricks.bggclient.fetch.domain;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "items", strict = false)
public class UserCollection {

    @Attribute(name = "totalitems", required = false)
	private int totalItems;

	@Attribute(name = "termsofuse", required = false)
	private String termsOfUseUrl;

	@Attribute(name = "pubdate", required = false)
	private String pubDate;

	@ElementList(inline = true, entry = "item", required = false)
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

    public String getPubDate() {
        return pubDate;
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
