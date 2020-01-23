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

public class Test3 {


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




    /*
         3   获取 音频文件   保存在: Audio_source 文件夹下面
     */
    @Test
    public void TTS_audio(){
        // TTS
        Querier<AbstractTTS> querierTTS = new Querier<>();
        querierTTS.setParams(LANG.EN, "To be or not to be, that is a question.");

        querierTTS.attach(new BaiduTTS());
        querierTTS.attach(new YoudaoTTS());
        querierTTS.attach(new GoogleTTS());
        querierTTS.attach(new TencentTTS());
        querierTTS.attach(new SogouTTS());

        List<String> resultTTS = querierTTS.execute();
        for (String str : resultTTS) {
            System.out.println(str);
        }

        // translator
        Querier<AbstractTranslator> querierTrans = new Querier<>();
        querierTrans.setParams(LANG.EN, LANG.ZH,"Happiness is a way station between too much and too little.");

        querierTrans.attach(new BaiduTranslator());
        querierTrans.attach(new YoudaoTranslator());
        querierTrans.attach(new GoogleTranslator());
        querierTrans.attach(new TencentTranslator());
        querierTrans.attach(new OmiTranslator());
        querierTrans.attach(new TrycanTranslator());
        querierTrans.attach(new IcibaTranslator());
        querierTrans.attach(new SogouTranslator());

        List<String> resultTrans = querierTrans.execute();
        for (String str : resultTrans) {
            System.out.println(str);
        }
    }




}