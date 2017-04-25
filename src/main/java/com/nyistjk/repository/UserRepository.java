package com.nyistjk.repository;

import com.nyistjk.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lvbowen on 2017/4/21.
 * we will be the best
 */
public interface UserRepository extends PagingAndSortingRepository<User,Integer> {
        User findByUserName(String name);
}
