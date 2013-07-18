package co.yellowbricks.bggclient.common.domain;

public enum Thing {

	BOARDGAME("boardgame");
	
	private final String type;
	
	private Thing(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
