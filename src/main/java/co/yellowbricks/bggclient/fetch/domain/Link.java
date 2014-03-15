package co.yellowbricks.bggclient.fetch.domain;

import org.simpleframework.xml.Attribute;

public class Link {

	@Attribute(name = "type", required = false)
	private String type;

	@Attribute(name = "id", required = false)
	private int id;

	@Attribute(name = "value", required = false)
	private String value;

	@Attribute(required = false)
	private String inbound;

	public String getType() {
        return type;
    }

	public int getId() {
        return id;
    }

	public String getValue() {
        return value;
    }

	public String getInbound() {
        return inbound;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        Link other = (Link) obj;
        if (id != other.id) {
            return false;
        }
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
