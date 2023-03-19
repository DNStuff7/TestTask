package com.example.powerplant;

import com.example.powerplant.repository.BatteryRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.hamcrest.CoreMatchers.*;

public class ApiTests extends PowerPlantApplicationTestsBase {
  
  @SpyBean
  public BatteryRepository batteryRepository;

  @LocalServerPort
  private int port;

  @Test
  void findAllByPostCodeBetweenTest() {
    Mockito.when(batteryRepository.findAllByPostCodeBetweenOrderByName(Mockito.anyString(), Mockito.anyString()))
        .thenReturn(generateMockListOfBatteries());
    RestAssured.given()
        .accept("application/json")
        .when()
        .port(this.port).contentType("application/json")
        .queryParam("postCodeMin", 1)
        .queryParam("postCodeMax", 4)
        .get("/batteries/byPostCodesRange")
        .then()
        .assertThat().statusCode(is(200))
        .body(is(notNullValue()))
        .body(is(containsString("\"44\"")))
        .body(is(containsString("100.0")))
        .body(is(containsString("25.0")));
  }
}