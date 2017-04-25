package com.nyistjk.controller;

import com.nyistjk.entity.Student;
import com.nyistjk.repository.StudentRepository;
import com.nyistjk.service.StudentService;
import com.nyistjk.utility.ViewUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


/**
 * Created by lvbowen on 2017/4/20.
 * we will be the best
 */
@Controller
public class ViewController {

    @GetMapping("/")
    public String home(){
        return "home";
    }


    @GetMapping("login")
    public String login(){
        return "login";
    }

}
