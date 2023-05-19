package team.codium.legacytraining.weather;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class GeoApiCityRepositoryTest {
    
    @Test
    public void get_coordinate_of_barcelona() throws IOException{
        GeoApiCityRepository repository = new GeoApiCityRepository();
        assertEquals(Coordinate.create((float)41.400347, (float)2.159592), repository.coordinateOf("Barcelona"));
    }
}
