package com.nyistjk.utility;

import com.nyistjk.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.servlet.http.HttpSession;

/**
 * Created by lvbowen on 2017/4/21.
 * we will be the best
 */
public class ViewUtility {
    public static String sortStr = "id";
    public static HttpSession session;
    public static Page pageSuccess(Integer page, Integer size, StudentService service){
        Sort sort = new Sort(Sort.Direction.ASC,sortStr);
        Pageable pageable = new PageRequest(page,size,sort);
        return service.findeAllStudent(pageable);
    }

}
