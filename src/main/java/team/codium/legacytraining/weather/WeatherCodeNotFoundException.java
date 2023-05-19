package team.codium.legacytraining.weather;

public class WeatherCodeNotFoundException extends RuntimeException{
    
    public WeatherCodeNotFoundException(int code){
        super(String.format("Weather code %d not found.", code));
    }
}
