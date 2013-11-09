package co.yellowbricks.bggclient.fetch.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class CollectionItem {

	@XmlAttribute(name = "objecttype")
	private String type;

	@XmlAttribute(name = "objectid", required = true)
	private int id;

	@XmlAttribute(name = "subtype")
	private String subtype;

	@XmlAttribute(name = "collid")
	private long collectionId;

	@XmlElement(name = "name")
	private String name;

	@XmlElement(name = "yearpublished")
	private String year;

	@XmlElement(name = "image")
	private String imageUrl;

	@XmlElement(name = "thumbnail")
	private String thumbnailUrl;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (collectionId ^ (collectionId >>> 32));
        result = prime * result + id;
        result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((subtype == null) ? 0 : subtype.hashCode());
        result = prime * result + ((thumbnailUrl == null) ? 0 : thumbnailUrl.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((year == null) ? 0 : year.hashCode());
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
        CollectionItem other = (CollectionItem) obj;
        if (collectionId != other.collectionId) {
            return false;
        }
        if (id != other.id) {
            return false;
        }
        if (imageUrl == null) {
            if (other.imageUrl != null) {
                return false;
            }
        } else if (!imageUrl.equals(other.imageUrl)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (subtype == null) {
            if (other.subtype != null) {
                return false;
            }
        } else if (!subtype.equals(other.subtype)) {
            return false;
        }
        if (thumbnailUrl == null) {
            if (other.thumbnailUrl != null) {
                return false;
            }
        } else if (!thumbnailUrl.equals(other.thumbnailUrl)) {
            return false;
        }
        if (type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!type.equals(other.type)) {
            return false;
        }
        if (year == null) {
            if (other.year != null) {
                return false;
            }
        } else if (!year.equals(other.year)) {
            return false;
        }
        return true;
    }
}
