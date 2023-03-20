package com.example.powerplant.service;

import com.example.powerplant.domain.BatteryDTO;
import com.example.powerplant.domain.BatteryInfoDTO;

import java.util.List;

public interface BatteryService {

  BatteryDTO getById(Long id);
  BatteryDTO save(BatteryDTO battery);
  void delete(Long id);
  List<BatteryDTO> findAll();
  BatteryInfoDTO findAllByPostCodeBetween(String codeMin, String codeMax);
}