package team.codium.legacytraining.weather;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class OpenMeteoApiWeatherRepositoryTest {
    
    @Test
    public void get_predictions_for_barcelona() throws IOException{
        OpenMeteoApiWeatherRepository repository = new OpenMeteoApiWeatherRepository();
        assertNotEquals(Prediction.NULL(), repository.predictionBy(Coordinate.create((float)41.400347, (float)2.159592), LocalDate.now(), false));
    }

    @Test
    public void get_wind_predictions_for_barcelona() throws IOException{
        OpenMeteoApiWeatherRepository repository = new OpenMeteoApiWeatherRepository();
        assertNotEquals(Prediction.NULL(), repository.predictionBy(Coordinate.create((float)41.400347, (float)2.159592), LocalDate.now(), true));
    }
}
