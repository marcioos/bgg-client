package co.yellowbricks.bggclient.fetch.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.google.common.base.Objects;

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
	
	@Override
	public int hashCode() {
		return Objects.hashCode(name, title, totalVotes, resultsList);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Poll) {
			Poll that = (Poll) obj;
			return Objects.equal(that.name, this.name)
					&& Objects.equal(that.title, this.title) && Objects.equal(that.resultsList, this.resultsList) && Objects.equal(that.totalVotes, this.resultsList);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
	public static final class Results {
		
		@XmlAttribute(name = "numplayers")
		private int numPlayers;
		
		@XmlElement(name = "result")
		private List<Result> results;
		
		public int getNumPlayers() {
			return numPlayers;
		}
		
		public List<Result> getResults() {
			return results;
		}
		
		@Override
		public int hashCode() {
			return Objects.hashCode(numPlayers, results);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Results) {
				Results that = (Results) obj;
				return Objects.equal(that.numPlayers, this.numPlayers) && Objects.equal(that.results, this.results);
			}
			return false;
		}
		
		@Override
		public String toString() {
			return ReflectionToStringBuilder.toString(this);
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
			return Objects.hashCode(value, numVotes);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Result) {
				Result that = (Result) obj;
				return Objects.equal(that.value, this.value) && Objects.equal(that.numVotes, this.numVotes);
			}
			return false;
		}
		
		@Override
		public String toString() {
			return ReflectionToStringBuilder.toString(this);
		}
	}
}
