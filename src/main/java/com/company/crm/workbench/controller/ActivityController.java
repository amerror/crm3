package com.company.crm.workbench.controller;

import com.company.crm.common.domain.Activity;
import com.company.crm.common.domain.User;
import com.company.crm.common.param.Result;
import com.company.crm.common.utils.DateTimeUtil;
import com.company.crm.common.utils.UUIDUtils;
import com.company.crm.settings.service.UserService;
import com.company.crm.workbench.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("workbench")
public class ActivityController {
    @Autowired
    private UserService userService;

    @Autowired
    private ActivityService activityService;

    @GetMapping("activity/index.do")
    public String toActivity(HttpServletRequest request){
        List<User> list = userService.selectAllUser();
        request.setAttribute("userList",list);
        return "workbench/activity/index";
    }

    @ResponseBody
    @PostMapping("activity/saveCreateActivity.do")
    public Result saveCreateActivity(Activity activity, HttpSession session){
        User user  = (User) session.getAttribute("userSession");
        String systemTime = DateTimeUtil.getSystemTime();
        activity.setCreate_time(systemTime);
        activity.setId(user.getId());
        activity.setId(UUIDUtils.getUUID());
        Result result = null;
        try{
            int insert = activityService.createActivity(activity);
            if(insert>0){
                result =  Result.success("");
            }else{
                result = Result.failed("400","系统忙,请稍后重试....");
            }
        }catch (Exception e){
            e.printStackTrace();
            result = Result.failed("400","系统忙,请稍后重试....");
        }
        return result;
    }
}
