package com.vendeton.computerComponents.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cooling_systems")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","ComputerMaintenanceCoolingSystems"})

public class CoolingSystems {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cooling_systems_id")
	private int coolingSystemsId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="property ")
	private String property ;
	
	@Column(name="price")
	private String price;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="place_of_use")
	private String placeOfUse;
	
	@Column(name="fan_diameter")
	private String fanDiameter;
	
	@Column(name="overclock")
	private String overclock;
	
	@ManyToOne()
	@JoinColumn(name = "computer_maintenance_id")
	private ComputerMaintenance ComputerMaintenanceCoolingSystems;


}
