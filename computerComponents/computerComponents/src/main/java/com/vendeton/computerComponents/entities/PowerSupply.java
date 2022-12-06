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
@Table(name = "power_supply")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","ComputerPartsPowerSupply"})

public class PowerSupply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="power_supply_id")
	private int powerSupplyId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="property ")
	private String property ;
	
	@Column(name="price")
	private String price;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="power_value")
	private String powerValue;
	
	@Column(name="efficiency")
	private String efficiency;
	
	@ManyToOne()
	@JoinColumn(name = "computer_parts_id")
	private ComputerParts ComputerPartsPowerSupply;


}
