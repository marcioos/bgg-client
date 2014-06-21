package co.yellowbricks.bggclient.search.domain;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import co.yellowbricks.bggclient.common.domain.Value;

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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((yearpublished == null) ? 0 : yearpublished.hashCode());
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
        SearchItem other = (SearchItem) obj;
        if (id != other.id) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!type.equals(other.type)) {
            return false;
        }
        if (yearpublished == null) {
            if (other.yearpublished != null) {
                return false;
            }
        } else if (!yearpublished.equals(other.yearpublished)) {
            return false;
        }
        return true;
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
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((type == null) ? 0 : type.hashCode());
            result = prime * result + ((value == null) ? 0 : value.hashCode());
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
            SearchItemName other = (SearchItemName) obj;
            if (type == null) {
                if (other.type != null) {
                    return false;
                }
            } else if (!type.equals(other.type)) {
                return false;
            }
            if (value == null) {
                if (other.value != null) {
                    return false;
                }
            } else if (!value.equals(other.value)) {
                return false;
            }
            return true;
        }
	}
}
