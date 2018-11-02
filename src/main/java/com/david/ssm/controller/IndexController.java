package com.david.ssm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.david.ssm.common.Result;
import com.david.ssm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController extends BaseController{

    @Autowired
    UserMapper userMapper;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public Result index() {
        IPage page = userMapper.selectPageVo(new Page(0, 2), 1);
        return Result.success(page);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public Result getUser() {
        return Result.success(userMapper.selectUserById((long) 1));
    }
}
