package team.codium.legacytraining.weather;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherKataTest {
    // https://positionstack.com/geo_api.php?query=Barcelona
    // https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&daily=weathercode,windspeed_10m_max&timezone=Europe%2FBerlin

    private CityRepository cityRepository;
    private WeatherRepository weatherRepository;
    @BeforeEach
    public void setUp() throws IOException{
        this.cityRepository = mock(CityRepository.class);
        when(this.cityRepository.coordinateOf(anyString())).thenReturn(Coordinate.create((float)41.400347, (float)2.159592));

        this.weatherRepository = mock(WeatherRepository.class);
    }

    @Test
    public void predictions_empty_when_the_date_is_greater_than_seven_days_from_today() throws IOException{
        assertEquals(Prediction.NULL(), new Forecast(this.cityRepository, this.weatherRepository).predict(null, LocalDate.now().plusDays(7), false));
    }
    
    @Test
    public void get_prediction_from_barcelona_today() throws IOException{
        when(this.weatherRepository.predictionBy(any(Coordinate.class), any(LocalDate.class), anyBoolean())).thenReturn(Prediction.create("Rain: Slight, moderate and heavy intensity"));
        assertEquals(Prediction.create("Rain: Slight, moderate and heavy intensity"), new Forecast(this.cityRepository, this.weatherRepository).predict("Barcelona", null, false));
    }

    @Test
    public void get_wind_prediction_from_barcelona_today() throws IOException{
        when(this.weatherRepository.predictionBy(any(Coordinate.class), any(LocalDate.class), anyBoolean())).thenReturn(Prediction.create("15.7"));
        assertEquals(Prediction.create("15.7"), new Forecast(this.cityRepository, this.weatherRepository).predict("Barcelona", null, true));
    }
}
