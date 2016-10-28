package co.yellowbricks.bggclient.search.domain;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import co.yellowbricks.bggclient.common.domain.Value;

import java.util.Objects;

@Root(name = "item", strict = false)
public class SearchItem {

    @Attribute
	private String type;

    @Attribute
	private int id;

    @Element
	private SearchItemName name;

    @Element(required = false)
	private Value yearpublished;

	public String getType() {
        return type;
    }

	public int getId() {
        return id;
    }

	public SearchItemName getName() {
        return name;
    }

	public Value getYear() {
        return yearpublished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SearchItem that = (SearchItem) o;
        return id == that.id &&
                Objects.equals(type, that.type) &&
                Objects.equals(name, that.name) &&
                Objects.equals(yearpublished, that.yearpublished);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, name, yearpublished);
    }

    public static final class SearchItemName {

	    @Attribute
		private String type;

	    @Attribute
		private String value;

		public String getType() {
            return type;
        }

		public String getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            SearchItemName that = (SearchItemName) o;
            return Objects.equals(type, that.type) &&
                    Objects.equals(value, that.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type, value);
        }
    }
}
