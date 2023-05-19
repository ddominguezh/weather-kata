package team.codium.legacytraining.weather;

import java.io.IOException;
import java.time.LocalDate;

public class Forecast {

    private CityRepository cityRepository;
    private WeatherRepository weatherRepository;

    public Forecast(CityRepository cityRepository, WeatherRepository weatherRepository){
        this.cityRepository = cityRepository;
        this.weatherRepository = weatherRepository;
    }
    public Prediction predict(String city, LocalDate datetime, boolean wind) throws IOException {
        // When date is not provided we look for the current prediction
        if (datetime == null) {
            datetime = LocalDate.now();
        }
        // If there are predictions
        if (datetime.isBefore(LocalDate.now().plusDays(7))) {
            Coordinate coordinate = this.cityRepository.coordinateOf(city);
            return this.weatherRepository.predictionBy(coordinate, datetime, wind);
        }
        return Prediction.NULL();
    }
}
