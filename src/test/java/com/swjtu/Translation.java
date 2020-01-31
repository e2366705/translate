package com.swjtu;

/*
  文本文件
 */

import com.swjtu.lang.LANG;
import com.swjtu.querier.Querier;
import com.swjtu.trans.AbstractTranslator;
import com.swjtu.trans.impl.*;
import com.swjtu.tts.AbstractTTS;
import com.swjtu.tts.impl.*;
import org.junit.Test;

import java.util.List;

public class Translation {

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
}