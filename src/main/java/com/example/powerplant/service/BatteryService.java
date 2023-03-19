package com.example.powerplant.service;

import com.example.powerplant.domain.Battery;
import com.example.powerplant.domain.BatteryNamesDTO;
import com.example.powerplant.repository.BatteryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatteryService {

  @Autowired
  public BatteryRepository batteryRepository;

  public Battery getById(Long id) {
    return batteryRepository.findById(id).orElse(null);
  }

  public Battery save(Battery battery) {
    return batteryRepository.save(battery);
  }

  public void delete(Battery battery) {
    batteryRepository.delete(battery);
  }

  public List<Battery> findAll() {
    return new ArrayList<>(batteryRepository.findAll());
  }

  public BatteryNamesDTO findAllByPostCodeBetween(String code1, String code2) {
    List<Battery> batteryList = batteryRepository.findAllByPostCodeBetweenOrderByName(code1, code2);
    Double summaryCapacity = calculateSum(batteryList);
    return BatteryNamesDTO
        .builder()
        .names(batteryList.stream().map(Battery::getName).collect(Collectors.toList()))
        .totalCapacity(summaryCapacity)
        .averageCapacity(calculateAverageCapacity(summaryCapacity, batteryList.size()))
        .build();
  }

  private Double calculateSum(List<Battery> batteryList) {
    return batteryList
        .stream().mapToDouble(Battery::getWattCapacity).sum();
  }

  private Double calculateAverageCapacity(Double sum, Integer numberOfElements) {
    return numberOfElements > 0 ? sum / numberOfElements : 0;
  }
}