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
@Table(name = "thermal_paste")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","ComputerMaintenanceThermalPaste"})

public class ThermalPaste {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="thermal_paste_id")
	private int thermalPasteId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="property ")
	private String property ;
	
	@Column(name="price")
	private String price;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="density")
	private String density;
	
	@Column(name="thermal_conductivity")
	private String thermalConductivity;

	
	@ManyToOne()
	@JoinColumn(name = "computer_maintenance_id")
	private ComputerMaintenance ComputerMaintenanceThermalPaste;
	
}
