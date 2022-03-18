package com.company.crm.settings.service;

import com.company.crm.common.domain.User;

import java.util.List;

/**
 * @author zytwl
 */
public interface UserService {
    /**
     * 按照账号密码登录
     * @param loginAct 账号
     * @param loginPwd 密码
     * @return
     * @author wanglin
     */
    User selectUserByActAndPwd(String loginAct, String loginPwd);


    /**
     * 查询所有用户的名称和id
     * @param
     * @return
     * @author wanglin
     */
    List<User> selectAllUser();
}
