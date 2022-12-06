package com.vendeton.computerComponents.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendeton.computerComponents.entities.MonitorsandAccessories;

public interface IMonitorsandAccessoriesDao extends JpaRepository<MonitorsandAccessories, Integer>{

	MonitorsandAccessories getByMonitorsandAccessoriesId(int monitorandAccessoriesId);

}
