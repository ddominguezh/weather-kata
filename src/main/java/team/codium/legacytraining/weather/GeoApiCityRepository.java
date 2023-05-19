package team.codium.legacytraining.weather;

import java.io.IOException;

import org.json.JSONObject;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;

public class GeoApiCityRepository implements CityRepository {

    @Override
    public Coordinate coordinateOf(String city) throws IOException {
        HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
        HttpRequest request = requestFactory.buildGetRequest(
                new GenericUrl("https://positionstack.com/geo_api.php?query=" + city));
        String rawResponse = request.execute().parseAsString();
        JSONObject jsonObject = new JSONObject(rawResponse);
        return Coordinate.create(jsonObject.getJSONArray("data").getJSONObject(0));
    }
    
}
