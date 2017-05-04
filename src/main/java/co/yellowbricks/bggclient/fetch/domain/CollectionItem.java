package co.yellowbricks.bggclient.fetch.domain;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.Objects;

@Root(name = "item", strict = false)
public class CollectionItem {

    @Attribute(name = "objecttype", required = false)
    private String type;

    @Attribute(name = "objectid", required = true)
    private int id;

    @Attribute(name = "subtype", required = false)
    private String subtype;

    @Attribute(name = "collid", required = false)
    private long collectionId;

    @Element(name = "name", required = false)
    private String name;

    @Element(name = "yearpublished", required = false)
    private String year;

    @Element(name = "image", required = false)
    private String imageUrl;

    @Element(name = "thumbnail", required = false)
    private String thumbnailUrl;

    @Element(required = false)
    private String status;

    @Element(required = false)
    private int numplays;

    @Element(required = false)
    private String comment;

    public long getCollectionId() {
        return collectionId;
    }

    public int getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getSubtype() {
        return subtype;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getType() {
        return type;
    }

    public String getYear() {
        return year;
    }

    public String getStatus() {
        return status;
    }

    public int getNumPlays() {
        return numplays;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CollectionItem that = (CollectionItem) o;
        return id == that.id &&
                collectionId == that.collectionId &&
                numplays == that.numplays &&
                Objects.equals(type, that.type) &&
                Objects.equals(subtype, that.subtype) &&
                Objects.equals(name, that.name) &&
                Objects.equals(year, that.year) &&
                Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(thumbnailUrl, that.thumbnailUrl) &&
                Objects.equals(status, that.status) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, subtype, collectionId, name, year,
                            imageUrl, thumbnailUrl, status, numplays, comment);
    }
}
