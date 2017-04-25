package com.nyistjk.service.impl;

import com.nyistjk.entity.Student;
import com.nyistjk.repository.StudentRepository;
import com.nyistjk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * Created by lvbowen on 2017/4/21.
 * we will be the best
 */

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student addStudent(Student student) {
        return repository.save(student);
    }

    @Override
    @Transient
    public Boolean deleteStudent(Student student) {
        if (repository.findOne(student.getId())!=null){
            repository.delete(student);
            return true;
        }
        return false;
    }

    @Override
    public Student findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Page<Student> findByAge(Integer age) {
        return null;
    }


    @Override
    public Page findeAllStudent(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Student motifyStudent(Student student) {
        return repository.save(student);
    }
}
