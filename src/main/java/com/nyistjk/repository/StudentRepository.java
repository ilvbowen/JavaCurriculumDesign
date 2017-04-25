package com.nyistjk.repository;

import com.nyistjk.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lvbowen on 2017/4/21.
 * we will be the best
 */
public interface StudentRepository extends PagingAndSortingRepository<Student,Integer> {
    Student findByName(String name);
    Student findByAge(Integer age);

    Page<Student> findAll(Pageable pageable);
}
