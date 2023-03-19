package com.example.powerplant.mapper;

import com.example.powerplant.domain.Battery;
import com.example.powerplant.domain.BatteryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BatteryMapper {
  @Mapping(target = "id", ignore = true)
  Battery toBattery(BatteryDTO source);
  BatteryDTO toBatteryDto(Battery target);
  List<BatteryDTO> toBatteryDtos(List<Battery> targets);
}
