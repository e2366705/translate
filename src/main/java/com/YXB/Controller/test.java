package com.YXB.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * @author YXB
 * @date 2020/2/1 13:49
 */
@Controller
public class test {

    @RequestMapping(value="/test", method= RequestMethod.GET)
    public String Root(){
        System.out.println("TEST..... ");
        return "test";
    }


    //   http://localhost:8083/test2?id=YXB
    @RequestMapping(value="/test2",method=RequestMethod.GET)
    @ResponseBody           //此注解不能省略 否则ajax无法接受返回值
    public String update(HttpServletRequest request){

        System.err.println(request.getParameter("id"));

        return request.getParameter("id");
    }


}