package com.company.crm.settings.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.company.crm.common.domain.User;
import com.company.crm.settings.dao.UserDao;
import com.company.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author zytwl
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserByActAndPwd(String loginAct, String loginPwd) {
        if(loginAct == ""||loginPwd == ""){
            return null;
        }

        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getLogin_act,loginAct);
        wrapper.eq(User::getLogin_pwd,loginPwd);
        User user1 = userDao.selectOne(wrapper);
        System.out.println(user1);
        return user1;
    }

    @Override
    public List<User> selectAllUser() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(User::getId,User::getName);
        List<User> users = userDao.selectList(wrapper);
        return users;
    }
}
