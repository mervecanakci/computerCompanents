package com.vendeton.computerComponents.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.ComputerMaintenance;

public interface IComputerMaintenanceDao extends JpaRepository<ComputerMaintenance, Integer>{

	ComputerMaintenance getByComputerMaintenanceId(int computerMaintenanceId);

}
