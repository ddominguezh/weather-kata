package team.codium.legacytraining.weather;

import java.io.IOException;

public interface CityRepository {

    Coordinate coordinateOf(String city) throws IOException;

}