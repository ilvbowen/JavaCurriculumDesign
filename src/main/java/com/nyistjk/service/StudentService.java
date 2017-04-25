package com.nyistjk.service;

import com.nyistjk.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * Created by lvbowen on 2017/4/21.
 * we will be the best
 */
public interface StudentService {

    //增
    Student addStudent(Student student);
    //删
    Boolean deleteStudent(Student student);
    //查
    Student findByName(String name);
    Page<Student> findByAge(Integer age);
    Page<Student> findeAllStudent(Pageable pageable);
    //改
    Student motifyStudent(Student student);


}
