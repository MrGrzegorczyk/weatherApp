package com.sda.weather.forecast;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ForecastService {

    private static final String APP_KEY_ID = "1766fdc82c622688913c1bb885b9bd94";
    private static final String URL = "https://api.openweathermap.org/data/2.5/onecall?lat=%s&lon=%s&appid=%s&units=metric";

    Forecast getForecast(Long locationId, Integer period) {
        // todo develop this method
        ForecastClientResponse forecastResponse = getForecastFromOpenweather(10.0, 20.0);

        return new Forecast();
    }

    ForecastClientResponse getForecastFromOpenweather(double longitude, double latitude) {
        try {
            String path = String.format(URL, longitude, latitude, APP_KEY_ID);
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(path))
                    .build();

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = httpResponse.body();

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return objectMapper.readValue(responseBody, ForecastClientResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Connection to the Openweather service faild");
        }
    }
}
