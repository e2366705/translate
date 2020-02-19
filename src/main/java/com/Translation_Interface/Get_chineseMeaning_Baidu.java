package com.Translation_Interface;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author YXB
 * @date 2020/2/10 12:19
 */
@Controller
public class Get_chineseMeaning_Baidu {

    /*
            测试...
            切记 , 不要命名为 test
            会冲突
     */


    //  示例:  访问            http://localhost:8083/Get_chineseMeaning_Baidu?word=miss
    @ResponseBody           //此注解不能省略 否则ajax无法接受返回值
    @RequestMapping(value="/Get_chineseMeaning_Baidu",method= RequestMethod.GET)
    public String Get_chineseMeaning_Baidu(HttpServletRequest request){
        System.err.println(request.getParameter("word"));
        System.err.println(request.getParameter("word"));
        System.err.println(request.getParameter("word"));

        Translate translate = new Translate();

        String english_word = request.getParameter("word");

        String translate_result = translate.Word_Translate_Baidu(english_word);

        return translate_result;
    }





}


class Translate{

    // 单纯单词翻译
    public String Word_Translate_Baidu(String english_words){


        //这个就是博客中的java反射的url
        final String url = "https://www.baidu.com/baidu?wd=" + english_words + "&tn=monline_4_dg&ie=utf-8";
        // https://www.baidu.com/baidu?wd=miss&tn=monline_4_dg&ie=utf-8

        try {
            //先获得的是整个页面的html标签页面
            Document doc = Jsoup.connect(url).get();

            //获取阅读数量
            //  class 是 .
            //  id    是 #
            Elements readEl = doc.select(".op_dict_text2");
            String word_chinese_meaning = readEl.text();
            System.err.println("中文意思是：" + word_chinese_meaning);
            return word_chinese_meaning;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "NULL";
    }
}



