package com.example.powerplant.service;

import com.example.powerplant.domain.Battery;
import com.example.powerplant.domain.BatteryDTO;
import com.example.powerplant.domain.BatteryInfoDTO;
import com.example.powerplant.mapper.BatteryMapper;
import com.example.powerplant.repository.BatteryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BatteryServiceImpl implements BatteryService {

  private final BatteryRepository batteryRepository;

  private final BatteryMapper batteryMapper;

  public BatteryDTO getById(Long id) {
    return batteryMapper.toBatteryDto(batteryRepository.findById(id).orElse(null));
  }

  public BatteryDTO save(BatteryDTO battery) {
    return batteryMapper.toBatteryDto(batteryRepository.save(batteryMapper.toBattery(battery)));
  }

  public void delete(Long id) {
    batteryRepository.deleteById(id);
  }

  public List<BatteryDTO> findAll() {
    return batteryMapper.toBatteryDtos(batteryRepository.findAll());
  }

  public BatteryInfoDTO findAllByPostCodeBetween(String codeMin, String codeMax) {
    List<Battery> batteryList = batteryRepository.findAllByPostCodeBetweenOrderByName(codeMin, codeMax);
    Double summaryCapacity = calculateSum(batteryList);
    return BatteryInfoDTO
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