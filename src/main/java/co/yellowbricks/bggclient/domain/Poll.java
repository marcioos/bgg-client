package co.yellowbricks.bggclient.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

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
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getTotalVotes() {
		return totalVotes;
	}
	
	public void setTotalVotes(int totalVotes) {
		this.totalVotes = totalVotes;
	}
	
	public List<Results> getResultsList() {
		return resultsList;
	}
	
	public void setResultsList(List<Results> resultsList) {
		this.resultsList = resultsList;
	}
	
	public static final class Results {
		
		@XmlAttribute(name = "numplayers")
		private int numPlayers;
		
		@XmlElement(name = "result")
		private List<Result> results;
		
		public int getNumPlayers() {
			return numPlayers;
		}
		
		public void setNumPlayers(int numPlayers) {
			this.numPlayers = numPlayers;
		}
		
		public List<Result> getResults() {
			return results;
		}
		
		public void setResults(List<Result> results) {
			this.results = results;
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
		
		public void setValue(String value) {
			this.value = value;
		}
		
		public int getNumVotes() {
			return numVotes;
		}
		
		public void setNumVotes(int numVotes) {
			this.numVotes = numVotes;
		}
	}
}
