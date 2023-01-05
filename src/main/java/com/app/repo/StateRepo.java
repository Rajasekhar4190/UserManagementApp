package com.app.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.StateMaster;

public interface StateRepo extends JpaRepository<StateMaster, Serializable> {
	List<StateMaster> findByCountryId(Integer countryId);

}
