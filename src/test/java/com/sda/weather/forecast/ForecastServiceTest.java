package com.sda.weather.forecast;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ForecastServiceTest {

    @Test
    void getForecastFromOpenweather_returnsProperResponse() {
        // given
        var objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        var forecastService = new ForecastService(objectMapper);
        // when
        var result = forecastService.getForecastFromOpenweather(54.0, 18.0);
        // then
        assertThat(result).isNotNull();
    }
}
