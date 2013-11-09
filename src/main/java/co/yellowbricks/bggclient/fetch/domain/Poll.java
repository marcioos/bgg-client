package co.yellowbricks.bggclient.fetch.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

//@Getter @EqualsAndHashCode @ToString
public class Poll {

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "title")
    private String title;

    @XmlAttribute(name = "totalvotes")
    private int totalVotes;

    @XmlElement(name = "results")
    private List<Results> resultsList;

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public List<Results> getResultsList() {
        return resultsList;
    }

    @XmlTransient
    public boolean isSuggestedNumPlayersPoll() {
        return getName().equals("suggested_numplayers");
    }

    public SuggestedNumPlayersPoll asSuggestedNumPlayersPoll() {
        return new SuggestedNumPlayersPoll(this);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((resultsList == null) ? 0 : resultsList.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + totalVotes;
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
        Poll other = (Poll) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (resultsList == null) {
            if (other.resultsList != null) {
                return false;
            }
        } else if (!resultsList.equals(other.resultsList)) {
            return false;
        }
        if (title == null) {
            if (other.title != null) {
                return false;
            }
        } else if (!title.equals(other.title)) {
            return false;
        }
        if (totalVotes != other.totalVotes) {
            return false;
        }
        return true;
    }

    public static final class Results {

        @XmlAttribute(name = "numplayers")
        private String numPlayers;

        @XmlElement(name = "result")
        private List<Result> results;

        public String getNumPlayers() {
            return numPlayers;
        }

        public List<Result> getResults() {
            return results;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((numPlayers == null) ? 0 : numPlayers.hashCode());
            result = prime * result + ((results == null) ? 0 : results.hashCode());
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
            Results other = (Results) obj;
            if (numPlayers == null) {
                if (other.numPlayers != null) {
                    return false;
                }
            } else if (!numPlayers.equals(other.numPlayers)) {
                return false;
            }
            if (results == null) {
                if (other.results != null) {
                    return false;
                }
            } else if (!results.equals(other.results)) {
                return false;
            }
            return true;
        }
    }

    public static final class Result {

        @XmlAttribute(name = "value")
        private String value;

        @XmlAttribute(name = "numvotes")
        private int numVotes;

        public String getValue() {
            return value;
        }

        public int getNumVotes() {
            return numVotes;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + numVotes;
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
            Result other = (Result) obj;
            if (numVotes != other.numVotes) {
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
