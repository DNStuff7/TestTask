package com.example.powerplant.service;

import com.example.powerplant.domain.Battery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DBFiller {

  @Autowired
  public BatteryService batteryService;

  //@PostConstruct
  public void populate() {
    batteryService.save(Battery.builder().name("Name I").postCode("12352").wattCapacity(36000.0).build());
    batteryService.save(Battery.builder().name("Name II").postCode("12351").wattCapacity(38000.0).build());
    batteryService.save(Battery.builder().name("Name III").postCode("12350").wattCapacity(52000.0).build());
    batteryService.save(Battery.builder().name("Name IV").postCode("12349").wattCapacity(20000.0).build());
    batteryService.save(Battery.builder().name("Name V").postCode("12348").wattCapacity(96000.0).build());
    batteryService.save(Battery.builder().name("Name XI").postCode("12347").wattCapacity(41000.0).build());
    batteryService.save(Battery.builder().name("Name VI").postCode("12346").wattCapacity(43000.0).build());
    batteryService.save(Battery.builder().name("Name XVII").postCode("12345").wattCapacity(67000.0).build());
  }
}