package co.yellowbricks.bggclient.fetch.domain;

import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FetchItemOutput that = (FetchItemOutput) o;
        return Objects.equals(termsOfUseUrl, that.termsOfUseUrl) &&
                Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(termsOfUseUrl, items);
    }
}
