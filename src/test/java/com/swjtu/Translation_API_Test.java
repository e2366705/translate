package com.swjtu;

/*
    各家翻译的水平如何
    测试
 */

import com.swjtu.lang.LANG;
import com.swjtu.querier.Querier;
import com.swjtu.trans.AbstractTranslator;
import com.swjtu.trans.impl.*;
import com.swjtu.tts.AbstractTTS;
import com.swjtu.tts.impl.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class Translation_API_Test {

    /*
        1    获取 文本文件
     */
    @Test
    public void Chinese_to_english(){
        //  https://github.com/hujingshuang/MTrans
        Querier<AbstractTranslator> querierTrans = new Querier<>();  // 获取查询器

        querierTrans.setParams(LANG.ZH, LANG.EN, "如果这都不算爱，我有什么好悲哀！");// 设置参数

        querierTrans.attach(new GoogleTranslator());// 向查询器中添加 Google 翻译器

        List<String> result = querierTrans.execute();// 执行查询并接收查询结果

        for (String str : result) {
            System.out.println(str);
        }
    }


    /*
        2        获取 文本文件
    */
    @Test
    public void English_to_chinese() throws InterruptedException {
        //  https://github.com/hujingshuang/MTrans
        Querier<AbstractTranslator> querierTrans = new Querier<>();  // 获取查询器

        querierTrans.setParams(LANG.EN, LANG.ZH, "Fashions change as time goes. If you look at pictures of people or things from the past，you will see that fashions have always changed. An English house of 1750 was different from one of 1650. A fashionable man in 1780 looked very different from his grandson in 1860");// 设置参数

        querierTrans.attach(new IcibaTranslator());// 向查询器中添加 Google 翻译器

        List<String> result = querierTrans.execute();// 执行查询并接收查询结果

        System.err.println(result.get(0));

        Thread.sleep(2222);

        for (String str : result) {
            System.out.println(str);
        }
    }



    // 目前最全面的翻译!!!
    // 原理是: 解析百度的网页
    // 翻译结果: 未得到; 未达到; 错过; 未见到; 未听到; 未觉察; 不理解; 不懂; (用于未婚女子姓氏或姓名前，以示礼貌) 小姐，女士; (选美比赛优胜者的头衔) 小姐; (称呼不知姓名的年轻女子) 小姐; 第三人称单数：misses 复数：misses 现在分词：missing 过去式：missed 过去分词：missed
    @Test
    public void Baidu_translate() {

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





    // 翻译单词: miss (小姐)
    // 成功, 翻译只有'小姐'一个意思, 不全面           by 2020-02-10 12:06:09
    @Test
    public void Translation_by_GoogleTranslator() throws InterruptedException {
        //  https://github.com/hujingshuang/MTrans
        Querier<AbstractTranslator> querierTrans = new Querier<>();  // 获取查询器

        querierTrans.setParams(LANG.EN, LANG.ZH, "miss");// 设置参数

        querierTrans.attach(new GoogleTranslator());// 向查询器中添加 Google 翻译器

        List<String> result = querierTrans.execute();// 执行查询并接收查询结果

        System.err.println(result.get(0));

        Thread.sleep(666);

        for (String str : result) {
            System.out.println(str);
        }
    }





    // 翻译单词: miss (小姐)
    // 成功, 翻译只有'小姐'一个意思, 不全面        2020-02-10 12:10:42
    @Test
    public void Translation_by_TencentTranslator() throws InterruptedException {
        //  https://github.com/hujingshuang/MTrans
        Querier<AbstractTranslator> querierTrans = new Querier<>();  // 获取查询器

        querierTrans.setParams(LANG.EN, LANG.ZH, "miss");// 设置参数

        querierTrans.attach(new TencentTranslator());// 向查询器中添加 Google 翻译器

        List<String> result = querierTrans.execute();// 执行查询并接收查询结果

        System.err.println(result.get(0));

        Thread.sleep(666);

        for (String str : result) {
            System.out.println(str);
        }
    }





    // 翻译单词: miss (小姐)
    // 翻译失败 看来百度已经封闭了这个接口           2020-02-10 12:07:08
    @Test
    public void Translation_by_BaiduTranslator() throws InterruptedException {
        //  https://github.com/hujingshuang/MTrans
        Querier<AbstractTranslator> querierTrans = new Querier<>();  // 获取查询器

        querierTrans.setParams(LANG.EN, LANG.ZH, "miss");// 设置参数

        querierTrans.attach(new BaiduTranslator());// 向查询器中添加 Google 翻译器

        List<String> result = querierTrans.execute();// 执行查询并接收查询结果

        System.err.println(result.get(0));

        Thread.sleep(666);

        for (String str : result) {
            System.out.println(str);
        }
    }










    // 翻译单词: miss (小姐)
    // 查询失败                 2020-02-10 12:08:03
    @Test
    public void Translation_by_IcibaTranslator() throws InterruptedException {
        //  https://github.com/hujingshuang/MTrans
        Querier<AbstractTranslator> querierTrans = new Querier<>();  // 获取查询器

        querierTrans.setParams(LANG.EN, LANG.ZH, "miss");// 设置参数

        querierTrans.attach(new IcibaTranslator());// 向查询器中添加 Google 翻译器

        List<String> result = querierTrans.execute();// 执行查询并接收查询结果

        System.err.println(result.get(0));

        Thread.sleep(666);

        for (String str : result) {
            System.out.println(str);
        }
    }









    // 翻译单词: miss (小姐)
    // 查询失败             2020-02-10 12:08:43
    @Test
    public void Translation_by_OmiTranslator() throws InterruptedException {
        //  https://github.com/hujingshuang/MTrans
        Querier<AbstractTranslator> querierTrans = new Querier<>();  // 获取查询器

        querierTrans.setParams(LANG.EN, LANG.ZH, "miss");// 设置参数

        querierTrans.attach(new OmiTranslator());// 向查询器中添加 Google 翻译器

        List<String> result = querierTrans.execute();// 执行查询并接收查询结果

        System.err.println(result.get(0));

        Thread.sleep(666);

        for (String str : result) {
            System.out.println(str);
        }
    }





    // 翻译单词: miss (小姐)
    // 查询失败             2020-02-10 12:09:17
    @Test
    public void Translation_by_SogouTranslator() throws InterruptedException {
        //  https://github.com/hujingshuang/MTrans
        Querier<AbstractTranslator> querierTrans = new Querier<>();  // 获取查询器

        querierTrans.setParams(LANG.EN, LANG.ZH, "miss");// 设置参数

        querierTrans.attach(new SogouTranslator());// 向查询器中添加 Google 翻译器

        List<String> result = querierTrans.execute();// 执行查询并接收查询结果

        System.err.println(result.get(0));

        Thread.sleep(666);

        for (String str : result) {
            System.out.println(str);
        }
    }













    // 翻译单词: miss (小姐)
    // 失败               2020-02-10 12:11:14
    @Test
    public void Translation_by_TrycanTranslator() throws InterruptedException {
        //  https://github.com/hujingshuang/MTrans
        Querier<AbstractTranslator> querierTrans = new Querier<>();  // 获取查询器

        querierTrans.setParams(LANG.EN, LANG.ZH, "miss");// 设置参数

        querierTrans.attach(new TrycanTranslator());// 向查询器中添加 Google 翻译器

        List<String> result = querierTrans.execute();// 执行查询并接收查询结果

        System.err.println(result.get(0));

        Thread.sleep(666);

        for (String str : result) {
            System.out.println(str);
        }
    }






    // 翻译单词: miss (小姐)
    //  失败              2020-02-10 12:12:01
    @Test
    public void Translation_by_YoudaoTranslator() throws InterruptedException {
        //  https://github.com/hujingshuang/MTrans
        Querier<AbstractTranslator> querierTrans = new Querier<>();  // 获取查询器

        querierTrans.setParams(LANG.EN, LANG.ZH, "miss");// 设置参数

        querierTrans.attach(new YoudaoTranslator());// 向查询器中添加 Google 翻译器

        List<String> result = querierTrans.execute();// 执行查询并接收查询结果

        System.err.println(result.get(0));

        Thread.sleep(666);

        for (String str : result) {
            System.out.println(str);
        }
    }





}