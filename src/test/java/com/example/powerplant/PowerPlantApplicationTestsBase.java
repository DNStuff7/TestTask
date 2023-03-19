package com.example.powerplant;

import com.example.powerplant.domain.Battery;
import com.example.powerplant.repository.BatteryRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@MockBean(BatteryRepository.class)
class PowerPlantApplicationTestsBase {

  protected List<Battery> generateMockListOfBatteries() {
    return Arrays.asList(Battery.builder().id(1L).name("11").postCode("1").wattCapacity(10D).build(),
        Battery.builder().id(2L).name("22").postCode("2").wattCapacity(20D).build(),
        Battery.builder().id(3L).name("33").postCode("3").wattCapacity(30D).build(),
        Battery.builder().id(4L).name("44").postCode("4").wattCapacity(40D).build());
  }
}
