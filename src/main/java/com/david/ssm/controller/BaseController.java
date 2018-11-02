package com.david.ssm.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(getClass().getSimpleName());

    protected String redirect(String url) {
        return "redirect:" + url;
    }

    protected void closeSession(HttpServletResponse response,
                                HttpSession session) {
        response.setHeader("Connection", "close");
        session.invalidate();
    }
}
