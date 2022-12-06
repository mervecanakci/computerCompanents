package com.vendeton.computerComponents.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.MonitorRiser;

public interface IMonitorRiserDao extends JpaRepository<MonitorRiser, Integer>{

	MonitorRiser getByName(String name);

	MonitorRiser getByPrice(String price);

	MonitorRiser getByMonitorRiserId(int monitorRiserId);

}
