package co.yellowbricks.bggclient.search.domain;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "items", strict = false)
public class SearchOutput {

    @Attribute
	private int total;

    @Attribute
	private String termsofuse;

    @ElementList(inline = true, entry = "item", required = false)
	private List<SearchItem> items;

	public int getTotal() {
        return total;
    }

	public String getTermsOfUseUrl() {
        return termsofuse;
    }

	public List<SearchItem> getItems() {
        return items;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((items == null) ? 0 : items.hashCode());
        result = prime * result + ((termsofuse == null) ? 0 : termsofuse.hashCode());
        result = prime * result + total;
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
        SearchOutput other = (SearchOutput) obj;
        if (items == null) {
            if (other.items != null) {
                return false;
            }
        } else if (!items.equals(other.items)) {
            return false;
        }
        if (termsofuse == null) {
            if (other.termsofuse != null) {
                return false;
            }
        } else if (!termsofuse.equals(other.termsofuse)) {
            return false;
        }
        if (total != other.total) {
            return false;
        }
        return true;
    }
}
