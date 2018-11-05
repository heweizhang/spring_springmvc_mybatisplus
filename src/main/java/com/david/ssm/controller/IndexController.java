package com.david.ssm.controller;


import com.david.ssm.common.Result;
import com.david.ssm.mapper.UserMapper;
import com.david.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class IndexController extends BaseController {

    @Autowired
    UserMapper userMapper;
    @Autowired
    IUserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", "你好");
        model.addAttribute("ifs", true);
        return "index";
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public Result getUser() {
      /*  Page page = userMapper.selectPageVo(new Page(0, 2), 1);
        return Result.success(page);*/
        return Result.success(userMapper.selectUserById((long) 1));
    }
}
