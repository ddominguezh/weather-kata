package team.codium.legacytraining.weather;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;

public class OpenMeteoApiWeatherRepository implements WeatherRepository {

    @Override
    public Prediction predictionBy(Coordinate coordinate, LocalDate datetime, boolean wind) throws IOException {
        String format = datetime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
        HttpRequest request = requestFactory.buildGetRequest(
                new GenericUrl("https://api.open-meteo.com/v1/forecast?latitude=" + coordinate.latitude() + "&longitude=" + coordinate.longitude() + "&daily=weathercode,windspeed_10m_max&current_weather=true&timezone=Europe%2FBerlin"));
                String rawResponse = request.execute().parseAsString();
        JSONObject results = new JSONObject(rawResponse).getJSONObject("daily");

        JSONArray times = results.getJSONArray("time");
        for (int i = 0; i < times.length(); i++) {
//            // When the date is the expected
            if (format.equals(times.get(i))) {
//                // If we have to return the wind information
                if (wind) {
                    return Prediction.create(String.valueOf(results.getJSONArray("windspeed_10m_max").getFloat(i)));
                } else {
                    int weatherCode = results.getJSONArray("weathercode").getInt(i);
                    return Prediction.create(weatherCode);
                }
            }
        }
        return Prediction.NULL();
    }
    
}
