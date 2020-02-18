package com.swjtu;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

/**
 * @author YXB
 * @date 2020/2/14 15:44
 */
public class Translate_Baidu {




    // 目前最全面的翻译!!!
    // 原理是: 解析百度的网页
    // 不支持   短句 / 词组
    // 翻译结果: 未得到; 未达到; 错过; 未见到; 未听到; 未觉察; 不理解; 不懂; (用于未婚女子姓氏或姓名前，以示礼貌) 小姐，女士; (选美比赛优胜者的头衔) 小姐; (称呼不知姓名的年轻女子) 小姐; 第三人称单数：misses 复数：misses 现在分词：missing 过去式：missed 过去分词：missed
    @Test
    public void Baidu_translate_word() {

        //  你要翻译的英文单词
        String english_words = "miss";

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
            String read = readEl.text();
            System.err.println("中文意思是：" + read);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    @Test
    public void Baidu_translate_phrase() {

        String  english_phrase = "a staple ingredient of comedy";
        String chinese_meaning = null;

        //这个就是博客中的java反射的url
        final String url = "https://www.baidu.com/baidu?wd=" + english_phrase + "&tn=monline_4_dg&ie=utf-8";
        // https://www.baidu.com/baidu?wd=a staple ingredient of comedy&tn=monline_4_dg&ie=utf-8

        try {
            //先获得的是整个页面的html标签页面
            Document doc = Jsoup.connect(url).get();

            //获取阅读数量
            //  class 是 .
            //  id    是 #
            Elements readEl = doc.select(".op_sp_fanyi_line_two");
            chinese_meaning = readEl.text();
            System.err.println("中文意思是：" + chinese_meaning);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
