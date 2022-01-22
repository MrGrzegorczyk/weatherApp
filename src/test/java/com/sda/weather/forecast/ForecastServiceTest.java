package com.sda.weather.forecast;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ForecastServiceTest {

    @Test
    void getForecastFromOpenweather_returnsProperResponse(){
        // given
        ForecastService forecastService = new ForecastService();
        // when
        ForecastClientResponse result = forecastService.getForecastFromOpenweather(54.0, 18.0);
        // then
        assertThat(result).isNotNull();
    }
}
