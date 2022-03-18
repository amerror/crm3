package com.company.crm.common.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zytwl
 */
@Data
@TableName("tbl_user")
public class User {
    @TableId
    private String id;
    private String login_act;
    private String name;
    private String login_pwd;
    private String email;
    private String expire_time;
    private String lock_state;
    private String deptno;
    private String allow_ips;
    private String createTime;
    private String create_by;
    private String edit_time;
    private String edit_by;
}
