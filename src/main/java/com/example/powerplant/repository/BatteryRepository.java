package com.example.powerplant.repository;

import com.example.powerplant.domain.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatteryRepository extends JpaRepository<Battery, Long> {

  List<Battery> findAllByPostCodeBetweenOrderByName(String postCodeMin, String postCodeMax);
}