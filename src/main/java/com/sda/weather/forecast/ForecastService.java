package com.sda.weather.forecast;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@RequiredArgsConstructor
public class ForecastService {

    private static final String APP_KEY_ID = "1766fdc82c622688913c1bb885b9bd94";
    private static final String URL = "https://api.openweathermap.org/data/2.5/onecall?lat=%s&lon=%s&appid=%s&units=metric";

    private final ObjectMapper objectMapper;

    Forecast getForecast(Long locationId, Integer period) {
        // todo develop this method
        ForecastClientResponse forecastResponse = getForecastFromOpenweather(10.0, 20.0);

        return new Forecast();
    }

    ForecastClientResponse getForecastFromOpenweather(double longitude, double latitude) {
        log.info("wywolano getForecastFromOpenweather");
        try {
            var path = String.format(URL, longitude, latitude, APP_KEY_ID);
            var httpRequest = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(path))
                    .build();

            var httpClient = HttpClient.newHttpClient();
            var httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            var responseBody = httpResponse.body();
            return objectMapper.readValue(responseBody, ForecastClientResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Connection to the Openweather service faild");
        }
    }
}
