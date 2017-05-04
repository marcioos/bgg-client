package co.yellowbricks.bggclient.fetch.domain;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import java.util.Objects;

@Root(name = "link", strict = false)
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Link link = (Link) o;
        return id == link.id &&
                Objects.equals(type, link.type) &&
                Objects.equals(value, link.value) &&
                Objects.equals(inbound, link.inbound);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, value, inbound);
    }
}
