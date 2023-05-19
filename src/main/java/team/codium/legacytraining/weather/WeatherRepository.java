package team.codium.legacytraining.weather;

import java.io.IOException;
import java.time.LocalDate;

public interface WeatherRepository {
    
    Prediction predictionBy(Coordinate coordinate, LocalDate datetime, boolean wind) throws IOException;

}
