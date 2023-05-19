package team.codium.legacytraining.weather;

import java.util.HashMap;
import java.util.Map;

public class Prediction {
    
    private String value;
    protected Prediction(String value){
        this.value = value;
    }
    public static Prediction create(String value){
        return new Prediction(value);
    }
    public static Prediction create(int code){
        return new Prediction(codeToText(code));
    }
    private static String codeToText(int weatherCode) {
        Map<Integer, String> translation = new HashMap<Integer, String>() {
            {
                put(0, "lear sky");
                put(1, "Mainly clear, partly cloudy, and overcast");
                put(2, "Mainly clear, partly cloudy, and overcast");
                put(3, "Mainly clear, partly cloudy, and overcast");
                put(45, "Fog and depositing rime fog");
                put(48, "Fog and depositing rime fog");
                put(51, "Drizzle: Light, moderate, and dense intensity");
                put(53, "Drizzle: Light, moderate, and dense intensity");
                put(55, "Drizzle: Light, moderate, and dense intensity");
                put(56, "Freezing Drizzle: Light and dense intensity");
                put(57, "Freezing Drizzle: Light and dense intensity");
                put(61, "Rain: Slight, moderate and heavy intensity");
                put(63, "Rain: Slight, moderate and heavy intensity");
                put(65, "Rain: Slight, moderate and heavy intensity");
                put(66, "Freezing Rain: Light and heavy intensity");
                put(67, "Freezing Rain: Light and heavy intensity");
                put(71, "Snow fall: Slight, moderate, and heavy intensity");
                put(73, "Snow fall: Slight, moderate, and heavy intensity");
                put(75, "Snow fall: Slight, moderate, and heavy intensity");
                put(77, "Snow grains");
                put(80, "Rain showers: Slight, moderate, and violent");
                put(81, "Rain showers: Slight, moderate, and violent");
                put(82, "Rain showers: Slight, moderate, and violent");
                put(85, "Snow showers slight and heavy");
                put(86, "Snow showers slight and heavy");
                put(95, "Thunderstorm: Slight or moderate");
                put(96, "Thunderstorm with slight and heavy hail");
                put(99, "Thunderstorm with slight and heavy hail");
            }
        };
        return translation.get(weatherCode);
    }
    public String value(){
        return this.value;
    }
}
