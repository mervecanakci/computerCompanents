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
@Table(name = "computer_cleaning_products")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","ComputerMaintenanceComputerCleaningProducts"})

public class ComputerCleaningProducts {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="computer_cleaning_products_id")
	private int computerCleaningProductsId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="property ")
	private String property ;
	
	@Column(name="price")
	private String price;
	
	@Column(name="brand")
	private String brand;
	
	@ManyToOne()
	@JoinColumn(name = "computer_maintenance_id")
	private ComputerMaintenance ComputerMaintenanceComputerCleaningProducts;


}
