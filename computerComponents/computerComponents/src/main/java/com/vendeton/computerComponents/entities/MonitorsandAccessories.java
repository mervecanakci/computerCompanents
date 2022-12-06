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
@Table(name = "monitor_and_accessories")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","monitor","monitorRiser","CatagoriesMonitorsandAccessories"})

public class MonitorsandAccessories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="monitor_and_accessories_id")
	private int monitorsandAccessoriesId;
	
	 @OneToMany(mappedBy="MonitorsandAccessoriesMonitor")
	    private List<Monitor> monitor;
	
	 @OneToMany(mappedBy="MonitorsandAccessoriesMonitorRiser")
	    private List<MonitorRiser> monitorRiser;
	
	 @ManyToOne()
		@JoinColumn(name = "catagories_id")
		private Catagories CatagoriesMonitorsandAccessories;

	
}
