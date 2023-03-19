package com.example.powerplant.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BatteryDTO {

  private String name;
  private String postCode;
  private Double wattCapacity;
}