package com.example.powerplant.api;

import com.example.powerplant.domain.Battery;
import com.example.powerplant.domain.BatteryNamesDTO;
import com.example.powerplant.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/powerplant")
public class BatteryController {
  
  @Autowired
  public BatteryService batteryService;

  @GetMapping(value = "/{id}", produces = "application/json")
  public Battery getById(@PathVariable("id") Long id) {
    return batteryService.getById(id);
  }

  @PostMapping(produces = "application/json")
  public Battery save(@RequestBody Battery battery) {
    return batteryService.save(battery);
  }

  @DeleteMapping
  public void delete(@RequestBody Battery battery) {
    batteryService.delete(battery);
  }

  @GetMapping(value = "/all", produces = "application/json")
  public List<Battery> findAll() {
    return batteryService.findAll();
  }

  @GetMapping(value = "/byPostCodesRange", produces = "application/json")
  public BatteryNamesDTO findByPostCodesRange(@RequestParam("postCode1") String postCode1, @RequestParam("postCode2") String postCode2) {
    return batteryService.findAllByPostCodeBetween(postCode1, postCode2);
  }
}