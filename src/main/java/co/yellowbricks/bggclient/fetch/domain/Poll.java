package co.yellowbricks.bggclient.fetch.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter @EqualsAndHashCode @ToString
public class Poll {

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "title")
    private String title;

    @XmlAttribute(name = "totalvotes")
    private int totalVotes;

    @XmlElement(name = "results")
    private List<Results> resultsList;
    
    @XmlTransient
    public boolean isSuggestedNumPlayersPoll() {
        return getName().equals("suggested_numplayers");
    }
    
    public SuggestedNumPlayersPoll asSuggestedNumPlayersPoll() {
        return new SuggestedNumPlayersPoll(this);
    }
    
    @Getter @EqualsAndHashCode @ToString
    public static final class Results {

        @XmlAttribute(name = "numplayers")
        private String numPlayers;

        @XmlElement(name = "result")
        private List<Result> results;
    }

    @Getter @EqualsAndHashCode @ToString
    public static final class Result {

        @XmlAttribute(name = "value")
        private String value;

        @XmlAttribute(name = "numvotes")
        private int numVotes;
    }
}
