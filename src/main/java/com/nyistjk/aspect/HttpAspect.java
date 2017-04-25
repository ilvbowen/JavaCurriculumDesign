package com.nyistjk.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by lvbowen on 2017/4/22.
 * we will be the best
 */
@Aspect
@Component
public class HttpAspect {
    @Before(value = "execution(public * com.nyistjk.controller.StudentController.*(..))")
    public void doBefor(JoinPoint joinPoint) throws IOException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        HttpSession session = request.getSession();
        Object object = session.getAttribute("level");
        if (object == null || Integer.parseInt(object.toString()) < 2){
            response.sendRedirect("/login");
        }

        String sort = request.getParameter("sort");
        if (sort != null){
            System.out.println(sort);
            session.setAttribute("sort",sort);
        }
    }

}
