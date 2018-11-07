package com.david.ssm.controller;

import com.david.ssm.common.Result;
import com.david.ssm.entity.User;
import com.david.ssm.service.IUserService;
import com.david.ssm.util.ReqUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class UserController extends BaseController {

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser(Model model) {
        List<User> list = userService.list(null);
        model.addAttribute("list", list);
        return "user";
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result user(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        closeSession(response, session);
        Map<String, String> params = ReqUtil.getReqKeyVals(request, new String[]{"id"});
        String id = params.get("id");
        if (StringUtils.isEmpty(id)) {
            return Result.error("id不能为空");
        }
        boolean flag = false;
        try {
            flag = userService.removeById(Long.parseLong(id));
        } catch (RuntimeException e) {
            return Result.error(-1, e.toString());
        }
        return flag ? Result.success() : Result.error(-1, "删除失败请稍后重试");
    }
}
