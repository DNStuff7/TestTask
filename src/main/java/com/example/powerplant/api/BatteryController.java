package com.example.powerplant.api;

import com.example.powerplant.domain.BatteryDTO;
import com.example.powerplant.domain.BatteryInfoDTO;
import com.example.powerplant.service.BatteryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/batteries")
@RequiredArgsConstructor
public class BatteryController {

  private final BatteryServiceImpl batteryService;

  @GetMapping(value = "/{id}")
  public BatteryDTO getById(@PathVariable("id") Long id) {
    return batteryService.getById(id);
  }

  @PostMapping
  public BatteryDTO save(@RequestBody BatteryDTO battery) {
    return batteryService.save(battery);
  }

  @DeleteMapping
  public void delete(@PathVariable Long id) {
    batteryService.delete(id);
  }

  @GetMapping(value = "/all")
  public List<BatteryDTO> findAll() {
    return batteryService.findAll();
  }

  @GetMapping(value = "/byPostCodesRange")
  public BatteryInfoDTO findByPostCodesRange(@RequestParam("postCodeMin") String postCodeMin, @RequestParam("postCodeMax") String postCodeMax) {
    return batteryService.findAllByPostCodeBetween(postCodeMin, postCodeMax);
  }
}