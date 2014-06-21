package co.yellowbricks.bggclient.fetch.domain;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "items", strict = false)
public class FetchItemOutput {

    @Attribute(name = "termsofuse", required = false)
	private String termsOfUseUrl;

	@ElementList(entry = "item", inline = true, required = false)
	private List<FetchItem> items;

	public String getTermsOfUseUrl() {
        return termsOfUseUrl;
    }

	public List<FetchItem> getItems() {
        return items;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((items == null) ? 0 : items.hashCode());
        result = prime * result + ((termsOfUseUrl == null) ? 0 : termsOfUseUrl.hashCode());
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
        FetchItemOutput other = (FetchItemOutput) obj;
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
        return true;
    }
}
