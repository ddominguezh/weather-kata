package team.codium.legacytraining.weather;

import org.json.JSONObject;

public class Coordinate {
    
    private float latitude;
    private float longitude;
    protected Coordinate(float latitude, float longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public float latitude(){
        return this.latitude;
    }
    public float longitude(){
        return this.longitude;
    }
    public static Coordinate create(JSONObject data) {
        return new Coordinate(data.getFloat("latitude"), data.getFloat("longitude"));
    }
}
