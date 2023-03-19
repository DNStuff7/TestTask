package com.example.powerplant.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BatteryNamesDTO {
  private List<String> names;
  private Double totalCapacity;
  private Double averageCapacity;  
}
