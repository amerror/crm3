package com.company.crm.workbench.service.impl;

import com.company.crm.common.domain.Activity;
import com.company.crm.workbench.dao.ActivityDao;
import com.company.crm.workbench.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zytwl
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;
    @Override
    public int createActivity(Activity activity) {
        System.out.println("activity:"+activity);
        int insert = activityDao.insert(activity);
        return insert;
    }
}
