package com.demo.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.springboot.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
