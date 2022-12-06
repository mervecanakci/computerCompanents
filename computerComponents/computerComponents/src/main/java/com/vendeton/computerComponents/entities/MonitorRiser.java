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
@Table(name = "monitor_riser")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","MonitorsandAccessoriesMonitorRiser"})

public class MonitorRiser {	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="monitor_riser_id")
	private int monitorRiserId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="property ")
	private String property ;
	
	@Column(name="price")
	private String price;
	
	@Column(name="brand")
	private String brand;	

	@Column(name="usage_type")
	private String usageType;
	
	@Column(name="screen_size")
	private String screenSize;	
	
	@ManyToOne()
	@JoinColumn(name = "monitor_and_accessories_id")
	private MonitorsandAccessories MonitorsandAccessoriesMonitorRiser;

	
	
}
