package com.github.bggclient.fetch.domain;

import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserCollection that = (UserCollection) o;
        return totalItems == that.totalItems &&
                Objects.equals(termsOfUseUrl, that.termsOfUseUrl) &&
                Objects.equals(pubDate, that.pubDate) &&
                Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalItems, termsOfUseUrl, pubDate, items);
    }
}
