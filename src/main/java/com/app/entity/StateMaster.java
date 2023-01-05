package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="state_master")
public class StateMaster {
	@Id
	private Integer stateId;
	private String stateName;
	private Integer countryId;

}
