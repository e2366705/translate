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