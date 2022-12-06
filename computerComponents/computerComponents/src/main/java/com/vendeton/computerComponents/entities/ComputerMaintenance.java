package com.vendeton.computerComponents.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vendeton.computerComponents.entities.abstracts.Catagories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "computer_maintenance")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","thermalPaste","coolingSystems","computerCleaningProducts","CatagoriesComputerMaintenance"})

public class ComputerMaintenance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="computer_maintenance_id")
	private int computerMaintenanceId;
	
	 @OneToMany(mappedBy="ComputerMaintenanceThermalPaste")
	    private List<ThermalPaste> thermalPaste;
	
	 @OneToMany(mappedBy="ComputerMaintenanceCoolingSystems")
	    private List<CoolingSystems> coolingSystems;
	
	
	 @OneToMany(mappedBy="ComputerMaintenanceComputerCleaningProducts")
	    private List<ComputerCleaningProducts> computerCleaningProducts;
	
	 @ManyToOne()
		@JoinColumn(name = "catagories_id")
		private Catagories CatagoriesComputerMaintenance;
	
	
}
