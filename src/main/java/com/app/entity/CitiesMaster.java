package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="citymaster")
public class CitiesMaster {
	@Id
	private Integer cityID;
	private String cityName;
	private Integer stateId;

}
