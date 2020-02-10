package com.YXB.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author YXB
 * @date 2020/2/1 13:42
 */


// sentence 句子
@Controller
public class Translation_sentence {

    @RequestMapping(value="/sentence", method= RequestMethod.GET)
    public String Root(){
        System.out.println("Translation  sentence  controller ");
        return "index.html";
    }
}