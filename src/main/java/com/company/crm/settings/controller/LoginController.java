package com.company.crm.settings.controller;

import com.company.crm.common.domain.User;
import com.company.crm.common.param.Result;
import com.company.crm.common.utils.DateTimeUtil;
import com.company.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author zytwl
 */
@Controller
@RequestMapping(value = "settings")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("qx/user/toLogin.do")
    public String toLogin(){
        return "settings/qx/user/login";
    }

    @PostMapping("qx/user/login.do")
    @ResponseBody
    public Result login(String loginAct, String loginPwd, String remPwd, HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println("进去UserController");
        User user = userService.selectUserByActAndPwd(loginAct,loginPwd);
        if(user == null){
            return Result.failed("404","账号密码错误");
        }
        String ip = request.getRemoteAddr();
        if (!user.getAllow_ips().contains(ip)){
            return Result.failed("404","该ip已被锁定");
        }
        if ("0".equals(user.getLock_state())){
            return Result.failed("404","该账户已被锁定");
        }
        String expire_time = user.getExpire_time();
        String systemTime = DateTimeUtil.getSystemTime();
        if (expire_time.compareTo(systemTime) < 0){
            return Result.failed("404","该账户已失效");
        }
        session.setAttribute("userSession",user);
        if ("true".equals(remPwd)){
            Cookie actCookie = new Cookie("loginAct", user.getLogin_act());
            Cookie pwdCookie = new Cookie("loginPwd", user.getLogin_pwd());
            actCookie.setMaxAge(10*24*60*60);
            pwdCookie.setMaxAge(10*24*60*60);
            response.addCookie(actCookie);
            response.addCookie(pwdCookie);
        }else{
            Cookie actCookie = new Cookie("loginAct", "1");
            Cookie pwdCookie = new Cookie("loginPwd", "2");
            actCookie.setMaxAge(0);
            pwdCookie.setMaxAge(0);
            response.addCookie(actCookie);
            response.addCookie(pwdCookie);
        }
        return Result.success(user);
    }

    @GetMapping("qx/user/loginOut.do")
    public String loginOut(HttpServletResponse response,HttpSession session){
        Cookie actCookie = new Cookie("loginAct", "1");
        Cookie pwdCookie = new Cookie("loginPwd", "2");
        actCookie.setMaxAge(0);
        pwdCookie.setMaxAge(0);
        response.addCookie(actCookie);
        response.addCookie(pwdCookie);
        session.invalidate();
        return "redirect:/";
    }
}
