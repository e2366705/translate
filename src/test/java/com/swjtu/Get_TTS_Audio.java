package com.swjtu;
import com.swjtu.lang.LANG;
import com.swjtu.querier.Querier;
import com.swjtu.trans.AbstractTranslator;
import com.swjtu.trans.impl.GoogleTranslator;
import com.swjtu.trans.impl.IcibaTranslator;
import com.swjtu.tts.AbstractTTS;
import com.swjtu.tts.impl.*;
import org.junit.Test;

import java.util.List;
public class Get_TTS_Audio {


    /*
          获取 音频文件   保存在: src\test\java\Audio_source 文件夹下面
          AbstractTTS 里面设置音频文件保存路径
     */
    @Test
    public void TTS_audio(){
        // TTS
        Querier<AbstractTTS> querierTTS = new Querier<>();
        querierTTS.setParams(LANG.EN, "To be or not to be, that is a question, i am OK");

//        querierTTS.attach(new BaiduTTS());
//        querierTTS.attach(new YoudaoTTS());
        querierTTS.attach(new GoogleTTS());
//        querierTTS.attach(new TencentTTS());
//        querierTTS.attach(new SogouTTS());

        List<String> resultTTS = querierTTS.execute();
        for (String str : resultTTS) {
            System.out.println(str);
        }
    }





/*
        经过测试,
        获取音频文件, 唯一能用的, 就是 Google 的..
        其他都不能用...
        测试时间: 2020-02-10
*/

/*
        2 google
     获取 音频文件   保存在: src\test\java\Audio_source 文件夹下面
     AbstractTTS 里面设置音频文件保存路径
*/
    @Test
    public void TTS_audio_word_by_GoogleTTS(){
        Querier<AbstractTTS> querierTTS = new Querier<>();
        querierTTS.setParams(LANG.EN, "i miss you so much Google");

        querierTTS.attach(new GoogleTTS());

        List<String> resultTTS = querierTTS.execute();
        for (String str : resultTTS) {
            System.out.println(str);
        }
    }


    // 中文测试 (测试成功, 可以用)
    @Test
    public void TTS_audio_word_by_GoogleTTS_for_chinese(){
        Querier<AbstractTTS> querierTTS = new Querier<>();
        querierTTS.setParams(LANG.ZH, "天气真糟糕");

        querierTTS.attach(new GoogleTTS());

        List<String> resultTTS = querierTTS.execute();
        for (String str : resultTTS) {
            System.out.println(str);
        }
    }











    /*
        1 baidu
         获取 音频文件   保存在: src\test\java\Audio_source 文件夹下面
         AbstractTTS 里面设置音频文件保存路径
         获取失败...
    */
    @Test
    public void TTS_audio_word_by_BaiduTTS(){
        Querier<AbstractTTS> querierTTS = new Querier<>();
        querierTTS.setParams(LANG.EN, "i miss you so much Baidu");

        querierTTS.attach(new BaiduTTS());

        List<String> resultTTS = querierTTS.execute();
        for (String str : resultTTS) {
            System.out.println(str);
        }
    }














    /*
    3 sougou
     获取 音频文件   保存在: src\test\java\Audio_source 文件夹下面
     AbstractTTS 里面设置音频文件保存路径
     获取失败...
*/
    @Test
    public void TTS_audio_word_by_SogouTTS(){
        Querier<AbstractTTS> querierTTS = new Querier<>();
        querierTTS.setParams(LANG.EN, "i miss you so much Sogou");

        querierTTS.attach(new SogouTTS());

        List<String> resultTTS = querierTTS.execute();
        for (String str : resultTTS) {
            System.out.println(str);
        }
    }








    /*
    4 tencent
     获取 音频文件   保存在: src\test\java\Audio_source 文件夹下面
     AbstractTTS 里面设置音频文件保存路径
     获取失败...
*/
    @Test
    public void TTS_audio_word_by_TencentTTS(){
        Querier<AbstractTTS> querierTTS = new Querier<>();
        querierTTS.setParams(LANG.EN, "i miss you so much Tencent");

        querierTTS.attach(new TencentTTS());

        List<String> resultTTS = querierTTS.execute();
        for (String str : resultTTS) {
            System.out.println(str);
        }
    }









    /*
    5 youdao
     获取 音频文件   保存在: src\test\java\Audio_source 文件夹下面
     AbstractTTS 里面设置音频文件保存路径
     获取失败...
*/
    @Test
    public void TTS_audio_word_by_YoudaoTTS(){
        Querier<AbstractTTS> querierTTS = new Querier<>();
        querierTTS.setParams(LANG.EN, "i miss you so much Youdao");

        querierTTS.attach(new YoudaoTTS());

        List<String> resultTTS = querierTTS.execute();
        for (String str : resultTTS) {
            System.out.println(str);
        }
    }



}