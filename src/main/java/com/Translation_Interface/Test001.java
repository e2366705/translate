package com.Translation_Interface;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author YXB
 * @date 2020/2/10 12:19
 */
@Controller
public class Test001 {

    /*
            测试...
            切记 , 不要命名为 test
            会冲突
     */


    // 单纯的返回字符串
    //  示例:  访问           http://localhost:8083/ttest?word=miss
    @ResponseBody           //此注解不能省略 否则ajax无法接受返回值
    @RequestMapping(value="/ttest",method= RequestMethod.GET)
    public String ttest(HttpServletRequest request){
        System.err.println(request.getParameter("word"));
        System.err.println(request.getParameter("word"));
        System.err.println(request.getParameter("word"));
        return "你大哥还是你大哥~~~";
    }



    // 返回json格式
    //  示例:  访问            http://localhost:8083/Return_json?word=Return_json
    @ResponseBody           //此注解不能省略 否则ajax无法接受返回值
    @RequestMapping(value="/Return_json",method= RequestMethod.GET)
    public List<News> Return_json(HttpServletRequest request){
        System.err.println(request.getParameter("word"));
        System.err.println(request.getParameter("word"));
        System.err.println(request.getParameter("word"));

        List<News> newsList = new ArrayList<>(3);
        News news1 = new News(1, "title1", "content1", new Date());
        News news2 = new News(2, "title2", "content2", new Date());
        News news3 = new News(3, "title3", "content3", new Date());
        newsList.add(news1);
        newsList.add(news2);
        newsList.add(news3);
        return newsList;
    }



}






class News implements Serializable {
    private int nid;
    private String newsTitle;
    private String newsContent;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date newsDate;

    public News(int nid, String newsTitle, String newsContent, Date newsDate) {
        this.nid = nid;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.newsDate = newsDate;
    }
}

