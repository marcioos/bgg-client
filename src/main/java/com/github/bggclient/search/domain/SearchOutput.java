package com.github.bggclient.search.domain;

import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SearchOutput that = (SearchOutput) o;
        return total == that.total &&
                Objects.equals(termsofuse, that.termsofuse) &&
                Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total, termsofuse, items);
    }
}
