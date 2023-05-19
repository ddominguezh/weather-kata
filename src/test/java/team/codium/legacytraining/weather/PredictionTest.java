package team.codium.legacytraining.weather;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PredictionTest {
    
    @Test
    public void throw_exception_when_weather_code_not_exists(){
        assertThrows(WeatherCodeNotFoundException.class, () -> {
            Prediction.create(Integer.MAX_VALUE);
        });
    }
}
