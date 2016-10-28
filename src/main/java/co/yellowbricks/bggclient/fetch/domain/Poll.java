package co.yellowbricks.bggclient.fetch.domain;

import java.util.List;
import java.util.Objects;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Transient;

@Root(name = "poll", strict = false)
public class Poll {

    @Attribute(name = "name", required = false)
    private String name;

    @Attribute(name = "title", required = false)
    private String title;

    @Attribute(name = "totalvotes", required = false)
    private int totalVotes;

    @ElementList(inline = true, entry = "results", required = false)
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

    @Transient
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

        @Attribute(name = "numplayers", required = false)
        private String numPlayers;

        @ElementList(inline = true, entry = "result", required = false)
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

        @Attribute(required = false)
        private int level;

        @Attribute(name = "value", required = false)
        private String value;

        @Attribute(name = "numvotes", required = false)
        private int numVotes;

        public int getLevel() {
            return level;
        }

        public String getValue() {
            return value;
        }

        public int getNumVotes() {
            return numVotes;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Result result = (Result) o;
            return level == result.level &&
                    numVotes == result.numVotes &&
                    Objects.equals(value, result.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(level, value, numVotes);
        }
    }
}
