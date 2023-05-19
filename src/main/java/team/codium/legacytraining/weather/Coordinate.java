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
        return Coordinate.create(data.getFloat("latitude"), data.getFloat("longitude"));
    }
    public static Coordinate create(float latitude, float longitude) {
        return new Coordinate(latitude, longitude);
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(latitude);
        result = prime * result + Float.floatToIntBits(longitude);
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinate other = (Coordinate) obj;
        if (Float.floatToIntBits(latitude) != Float.floatToIntBits(other.latitude))
            return false;
        if (Float.floatToIntBits(longitude) != Float.floatToIntBits(other.longitude))
            return false;
        return true;
    }
}
