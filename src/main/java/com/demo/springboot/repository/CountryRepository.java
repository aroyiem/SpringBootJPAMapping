package com.demo.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.springboot.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

}
