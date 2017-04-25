package com.nyistjk.controller;

import com.nyistjk.entity.Student;
import com.nyistjk.repository.StudentRepository;
import com.nyistjk.service.StudentService;
import com.nyistjk.utility.ViewUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by lvbowen on 2017/4/22.
 * we will be the best
 */
@Controller
public class StudentController {

    private final StudentRepository repository;
    private final StudentService service;
    @Autowired
    public StudentController(StudentService service, StudentRepository repository) {
        this.service = service;
        this.repository = repository;
    }
    @GetMapping("sort")
    public String sort(@RequestParam String sort,Model model){
        ViewUtility.sortStr = sort;
        model.addAttribute("students",ViewUtility.pageSuccess(0,5,service));
        return "index";
    }
    @GetMapping("index")
    public String index(@RequestParam(defaultValue = "0") Integer page,
                        @RequestParam(defaultValue = "5") Integer size,
                        Model model, HttpSession session){
        model.addAttribute("students", ViewUtility.pageSuccess(page,size,service));
        return "index";
    }

    @GetMapping("modify")
    public String modify(Model model,
                         @RequestParam Integer id){
        model.addAttribute("student", repository.findOne(id));
        return "user/modify";
    }
    @GetMapping("delete")
    public String delete(Model model,
                         @RequestParam Integer id){
        Student student = repository.findOne(id);
        repository.delete(student);
        model.addAttribute("students", ViewUtility.pageSuccess(0,5,service));
        return "redirect:index";
    }

    @PostMapping("modify")
    public String modifyStudent(Student student,Model model){
        service.motifyStudent(student);
        model.addAttribute("students",ViewUtility.pageSuccess(0,5,service));
        return "index";
    }
    @GetMapping("addStudent")
    public String add(){
        return "user/add";
    }
    @PostMapping("addStudent")
    public String addStudent(Student student,Model model){
        repository.save(student);
        model.addAttribute("students",ViewUtility.pageSuccess(0,5,service));
        return "index";
    }

}
