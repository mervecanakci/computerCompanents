package com.vendeton.computerComponents.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.Monitor;

public interface IMonitorDao  extends JpaRepository<Monitor, Integer>{

	Monitor getByName(String name);
/*
	Monitor getByName(String name);

	Monitor getByPrice(String price);

	Monitor getByMonitorId(int monitorId);

*/

	Monitor getByPrice(String price);

	Monitor getByMonitorId(int monitorId);


}
