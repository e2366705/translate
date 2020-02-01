package com.YXB.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author YXB
 * @date 2020/2/1 13:42
 */


@Controller
public class Translation_word {

    @RequestMapping(value="/word", method= RequestMethod.GET)
    public String Root(){
        System.out.println("Translation_word_Controller word");
        return "index";
    }
}