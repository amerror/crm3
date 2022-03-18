package com.company.crm.workbench.service;

import com.company.crm.common.domain.Activity;

/**
 * @author zytwl
 */
public interface ActivityService {

    /**
     * 创建市场活动
     * @param activity 市场活动信息
     * @return
     * @author wanglin
     */
    int createActivity(Activity activity);
}
