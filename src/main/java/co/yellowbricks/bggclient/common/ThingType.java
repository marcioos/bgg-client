package co.yellowbricks.bggclient.common;

import java.util.HashMap;
import java.util.Map;

public enum ThingType {

    BOARDGAME("boardgame"), BOARDGAME_EXPANSION("boardgameexpansion");
    
    private static final Map<String, ThingType> thingMap = new HashMap<String, ThingType>();
    
    static {
        for (ThingType type : values()) thingMap.put(type.key, type);
    }
    
    private final String key;
    
    ThingType(String key) {
        this.key = key;
    }
    
    public String getKey() {
        return key;
    }
}
