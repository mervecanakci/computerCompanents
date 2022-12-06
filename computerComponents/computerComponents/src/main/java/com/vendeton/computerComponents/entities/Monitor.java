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
@Table(name = "monitor")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","MonitorsandAccessoriesMonitor"})

public class Monitor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="monitor_id")
	private int monitorId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="property ")
	private String property ;
	
	@Column(name="price")
	private String price;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="screen_size")
	private String screenSize;
	
	@Column(name="refresh_rate ")
	private String refreshRate ;
	
	@Column(name="resolution")
	private String resolution;
	
	@Column(name="response_time")
	private String responseTime;
	
	@Column(name="panel_type")
	private String panelType;
	
	@Column(name="usage_type ")
	private String usageType ;
	
	@Column(name="surface_type")
	private String surfaceType;
	
	@Column(name="sync_technology")
	private String syncTechnology;
	
	@Column(name="HDR")
	private String HDR;
	
	@Column(name="HDMI")
	private String HDMI;
	
	
	@ManyToOne()
	@JoinColumn(name = "monitor_and_accessories_id")
	private MonitorsandAccessories MonitorsandAccessoriesMonitor;


}
