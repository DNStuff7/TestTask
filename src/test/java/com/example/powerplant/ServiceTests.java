package com.example.powerplant;

import com.example.powerplant.domain.Battery;
import com.example.powerplant.domain.BatteryDTO;
import com.example.powerplant.domain.BatteryInfoDTO;
import com.example.powerplant.repository.BatteryRepository;
import com.example.powerplant.service.BatteryServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Power plant service tests")
public class ServiceTests extends PowerPlantApplicationTestsBase {

  @Autowired
  public BatteryServiceImpl batteryService;

  @MockBean
  public BatteryRepository batteryRepository;

  @Test
  @DisplayName("Finding all entities")
  void findAllTest() {
    List<Battery> batteries = generateMockListOfBatteries();
    Mockito.when(batteryRepository.findAll()).thenReturn(batteries);
    List<BatteryDTO> batteriesFound = batteryService.findAll();
    assertNotNull(batteriesFound);
    assertEquals(batteries.size(), batteriesFound.size());
  }

  @Test
  @DisplayName("Finding by post code in range")
  void findAllByPostCodeBetweenTest() {
    Mockito.when(batteryRepository.findAllByPostCodeBetweenOrderByName(Mockito.anyString(), Mockito.anyString()))
        .thenReturn(generateMockListOfBatteries());
    BatteryInfoDTO namesDTO = batteryService.findAllByPostCodeBetween("1", "4");
    assertNotNull(namesDTO);
    assertNotNull(namesDTO.getNames());
    assertEquals(4, namesDTO.getNames().size());
    assertEquals("44", namesDTO.getNames().get(3));
    assertEquals(100D, namesDTO.getTotalCapacity());
    assertEquals(25D, namesDTO.getAverageCapacity());
    Mockito.reset(batteryRepository);
  }
}