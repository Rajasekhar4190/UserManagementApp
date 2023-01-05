package com.app.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.CountryMaster;

public interface countryRepo extends JpaRepository<CountryMaster, Serializable> {

}
