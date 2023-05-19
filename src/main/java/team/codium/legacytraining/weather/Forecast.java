package team.codium.legacytraining.weather;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Forecast {

    private CityRepository cityRepository;
    public Forecast(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }
    public Prediction predict(String city, LocalDate datetime, boolean wind) throws IOException {
        // When date is not provided we look for the current prediction
        if (datetime == null) {
            datetime = LocalDate.now();
        }
        // If there are predictions
        if (datetime.isBefore(LocalDate.now().plusDays(7))) {
            Coordinate coordinate = this.cityRepository.coordinateOf(city);
            return new OpenMeteoApiWeatherRepository().predictionBy(coordinate, datetime, wind);
        }
        return Prediction.NULL();
    }
}
