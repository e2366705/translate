package com.Translation_Interface;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author YXB
 * @date 2020/2/10 12:19
 */
@Controller
public class Translation_Interface {


    //  示例:  访问  http://localhost:8083/Translation?word=miss
    @RequestMapping(value="/Translation",method= RequestMethod.GET)
    @ResponseBody           //此注解不能省略 否则ajax无法接受返回值
    public String Translation(HttpServletRequest request){
        System.err.println(request.getParameter("id"));
        return "你大哥还是你大哥~~~";
    }





}
