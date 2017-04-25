package com.nyistjk.controller;

import com.nyistjk.entity.User;
import com.nyistjk.repository.UserRepository;
import com.nyistjk.service.StudentService;
import com.nyistjk.utility.ViewUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by lvbowen on 2017/4/20.
 * we will be the best
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private final UserRepository repository;
    @Autowired
    StudentService service;
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("sign/in")
    public String login(User user, HttpSession session, Model model){
        User newUser = repository.findByUserName(user.getUserName());
        if (newUser != null && newUser.getPassword().equals(user.getPassword())){
            session.setAttribute("user",newUser.getUserName());
            session.setAttribute("level",newUser.getLevel());
            ViewUtility.session = session;
            model.addAttribute("students", ViewUtility.pageSuccess(0,5,service));
            model.addAttribute("name",session.getAttribute("user"));
            return "redirect:/index";
        }
        return "login";
    }

    @PostMapping("sign/up")
    public String register(User user, HttpSession session,Model model){
        User newUser = repository.findByUserName(user.getUserName());
        if (newUser == null ){
            repository.save(user);
            session.setAttribute("user",user.getUserName());
            model.addAttribute("students", ViewUtility.pageSuccess(0,5,service));
            model.addAttribute("name",session.getAttribute("user"));
            return "redirect:/index";
        }
        else {
            model.addAttribute("msg","用户名已存在");
            return "login";
        }
    }
    @GetMapping("login/out")
    public String loginOut(HttpSession session){
        session.removeAttribute("name");
        session.removeAttribute("level");
        return "login";
    }

}
