package com.app.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.CitiesMaster;

public interface CitiyRepo extends JpaRepository<CitiesMaster, Serializable> {
	List<CitiesMaster> findByStateId(Integer stateId);

}
