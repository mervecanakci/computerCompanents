package com.vendeton.computerComponents.business.abstracts;


import java.util.List;

import com.vendeton.computerComponents.core.utilites.result.DataResult;
import com.vendeton.computerComponents.core.utilites.result.Result;
import com.vendeton.computerComponents.entities.MonitorsandAccessories;

public interface IMonitorsandAccessoriesService {
	DataResult<List<MonitorsandAccessories>> getAll();

Result add(MonitorsandAccessories monitorsandAccessories);
	

	DataResult<MonitorsandAccessories> getByMonitorsandAccessoriesId(int monitorandAccessoriesId);

	Result deleteByMonitorsandAccessoriesId(int monitorandAccessoriesId);

}
