package com.swjtu;
import com.swjtu.lang.LANG;
import com.swjtu.querier.Querier;
import com.swjtu.trans.AbstractTranslator;
import com.swjtu.trans.impl.GoogleTranslator;
import com.swjtu.trans.impl.IcibaTranslator;
import com.swjtu.tts.AbstractTTS;
import com.swjtu.tts.impl.GoogleTTS;
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
        querierTTS.setParams(LANG.EN, "To be or not to be, that is a question.");

//        querierTTS.attach(new BaiduTTS());
//        querierTTS.attach(new YoudaoTTS());
        querierTTS.attach(new GoogleTTS());
//        querierTTS.attach(new TencentTTS());
//        querierTTS.attach(new SogouTTS());

        List<String> resultTTS = querierTTS.execute();
        for (String str : resultTTS) {
            System.out.println(str);
        }

        // translator
        Querier<AbstractTranslator> querierTrans = new Querier<>();
        querierTrans.setParams(LANG.EN, LANG.ZH,"Happiness is a way station between too much and too little.");

//        querierTrans.attach(new BaiduTranslator());
//        querierTrans.attach(new YoudaoTranslator());
        querierTrans.attach(new GoogleTranslator());
//        querierTrans.attach(new TencentTranslator());
//        querierTrans.attach(new OmiTranslator());
//        querierTrans.attach(new TrycanTranslator());
//        querierTrans.attach(new IcibaTranslator());
//        querierTrans.attach(new SogouTranslator());

        List<String> resultTrans = querierTrans.execute();
        for (String str : resultTrans) {
            System.out.println(str);
        }
    }



    /*
     获取 音频文件   保存在: src\test\java\Audio_source 文件夹下面
     AbstractTTS 里面设置音频文件保存路径
 */
    @Test
    public void TTS_audio_word(){
        // TTS
        Querier<AbstractTTS> querierTTS = new Querier<>();
        querierTTS.setParams(LANG.EN, "miss");

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
}