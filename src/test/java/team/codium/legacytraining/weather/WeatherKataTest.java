package team.codium.legacytraining.weather;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherKataTest {
    // https://positionstack.com/geo_api.php?query=Barcelona
    // https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&daily=weathercode,windspeed_10m_max&timezone=Europe%2FBerlin

    @Test
    public void xxx() throws IOException {
        new Forecast();
    
        assertEquals("xxx", "xxx");
    }

    @Test
    public void predictions_empty_when_the_date_is_greater_than_seven_days_from_today() throws IOException{
        assertEquals("", new Forecast().predict(null, LocalDate.now().plusDays(7), false));
    }
    
    @Test
    public void get_prediction_from_barcelona_today() throws IOException{
        assertEquals("Rain: Slight, moderate and heavy intensity", new Forecast().predict("Barcelona", null, false));
    }

    @Test
    public void get_wind_prediction_from_barcelona_today() throws IOException{
        assertEquals("15.7", new Forecast().predict("Barcelona", null, true));
    }
}