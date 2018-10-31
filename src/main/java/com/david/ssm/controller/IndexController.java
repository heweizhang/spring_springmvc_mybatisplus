package com.david.ssm.controller;

import com.david.ssm.HelloWorld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    protected final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    HelloWorld helloWorld;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public String index() {
        helloWorld.setMessage("wahaha");
        helloWorld.getMessage();
        logger.info("IndexController index={}", "ss");
        return "index";
    }
}
