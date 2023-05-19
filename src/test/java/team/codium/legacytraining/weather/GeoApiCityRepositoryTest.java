package team.codium.legacytraining.weather;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class GeoApiCityRepositoryTest {
    
    @Test
    public void get_coordinate_of_barcelona() throws IOException{
        GeoApiCityRepository repository = new GeoApiCityRepository();
        assertEquals(CoordinateMother.for_barcelona(), repository.coordinateOf("Barcelona"));
    }
}
