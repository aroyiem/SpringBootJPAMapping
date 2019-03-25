package com.demo.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.springboot.entity.CountryLanguage;
import com.demo.springboot.entity.CountryLanguagePK;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguagePK> {

}
