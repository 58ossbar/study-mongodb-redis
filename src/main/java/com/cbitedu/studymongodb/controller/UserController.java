package com.cbitedu.studymongodb.controller;

import com.cbitedu.studymongodb.entity.User;
import com.cbitedu.studymongodb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Slf4j
@Controller
public class UserController {
    @Autowired
    private UserService us;
    @Autowired
    MongoTemplate mongoTemplate;

    //设置首页
    @RequestMapping(value = "/")
    public String index() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userList(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        User user = us.findUserByUsername(username);
        log.info("username:" + username + "\npassword:" + password);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                model.addAttribute("user", user);
                return "index";
            } else {
                log.info("密码不正确");
                model.addAttribute("msg", "密码不正确");
            }
        } else {
            log.info("用户不存在");
            model.addAttribute("msg", "用户不存在");
        }
        return "login";
    }

    @ResponseBody
    @RequestMapping("/find")
    public List<User> find() {
        return mongoTemplate.findAll(User.class);
    }
}
