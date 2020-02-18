package com.swjtu;

import org.json.JSONException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import org.json.JSONObject;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.test.context.TestExecutionListeners;

import javax.swing.plaf.PanelUI;
import java.util.HashMap;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;

/**
 * @author YXB
 * @date 2020/2/14 15:44
 */

/*
            亲测可以用
            挺好用...
 */

//      Translate
//      https://fanyi.so.com/index/search?eng=1&validate=&ignore_trans=0&query=i miss you       -> 格式错误
//      https://fanyi.so.com/index/search?eng=1&validate=&ignore_trans=0&query=i%20miss%20you   -> 正确

public class Translate_360 {


    // 翻译短句
    @Test
    public void Translate_Phrase() throws JSONException {
        try{
            URL url = new URL("https://fanyi.so.com/index/search?eng=1&validate=&ignore_trans=0&query=i%20miss%20you");//网址链接
            URLConnection conn = url.openConnection(); //打开链接
            //获取网页的源代码
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            String json_data = "";
            while ((line = br.readLine()) != null) {
                json_data = line;
            }
            System.out.println(json_data);//输出内容
            br.close();

            JSONObject jsonobj = new JSONObject(json_data);

            JSONObject data = (JSONObject) jsonobj.get("data");
            Object fanyi = data.get("fanyi");

            String fanyi_result = String.valueOf(fanyi);
            System.err.println("中文意思是:         "+fanyi_result);


        } catch (MalformedURLException ex) {
            Logger.getLogger(Translate_360.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Translate_360.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    // 翻译 单纯的单词
    // miss  翻译成  小姐
    // 没有百度翻译全面
    @Test
    public void Translate_Word() throws JSONException {
        try{
            URL url = new URL("https://fanyi.so.com/index/search?eng=1&validate=&ignore_trans=0&query=miss");//网址链接
            URLConnection conn = url.openConnection(); //打开链接
            //获取网页的源代码
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            String json_data = "";
            while ((line = br.readLine()) != null) {
                json_data = line;
            }
            System.out.println(json_data);//输出内容
            br.close();

            JSONObject jsonobj = new JSONObject(json_data);

            JSONObject data = (JSONObject) jsonobj.get("data");
            Object fanyi = data.get("fanyi");

            String fanyi_result = String.valueOf(fanyi);
            System.err.println("中文意思是:         "+fanyi_result);


        } catch (MalformedURLException ex) {
            Logger.getLogger(Translate_360.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Translate_360.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

