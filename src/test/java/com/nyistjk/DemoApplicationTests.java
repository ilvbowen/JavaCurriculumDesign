package com.nyistjk;

import com.nyistjk.entity.Student;
import com.nyistjk.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	StudentRepository repository;

	@Test
	public void contextLoads() {
		Pageable pageable = new PageRequest(0,5);
		Page page =  repository.findAll(pageable);

		System.out.println(repository.findByName("南小工"));
	}

}
