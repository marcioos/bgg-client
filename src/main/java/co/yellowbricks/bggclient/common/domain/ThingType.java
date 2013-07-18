package co.yellowbricks.bggclient.common.domain;

public enum ThingType {

	BOARDGAME("boardgame");
	
	private final String type;
	
	private ThingType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
