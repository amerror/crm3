package com.company.crm.common.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zytwl
 */
@Data
@TableName("tbl_activity")
public class Activity {
    private String id;
    private String owner;
    private String name;
    private String start_date;
    private String end_date;
    private String cost;
    private String description;
    private String create_time;
    private String create_by;
    private String edit_time;
    private String edit_by;

}
