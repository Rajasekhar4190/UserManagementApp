package com.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="country_master")
public class CountryMaster {
	@Id
	private Integer countryID;
	private String countryName;

}
