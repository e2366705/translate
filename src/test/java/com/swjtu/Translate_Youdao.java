package com.swjtu;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Translate_Youdao {
    public static void main(String[] args) throws JSONException {

        // 调用 有道翻译
        // 单词是 : i miss you

        Get_json get_json = new Get_json();
        Analysis_json analysis_json = new Analysis_json();

        String json = get_json.Get_json_by_Youdao();
        String chinese_meaning = analysis_json.Analysis(json);




    }
}



class Get_json{
    public String Get_json_by_Youdao(){
        try{
            URL url = new URL("http://fanyi.youdao.com/openapi.do?keyfrom=xinlei&key=759115437&type=data&doctype=json&version=1.1&q=i%20miss%20you");//网址链接
            URLConnection conn = url.openConnection(); //打开链接
            //获取网页的源代码
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            String json = "";
            while ((line = br.readLine()) != null) {
                json = line;
            }
            System.err.println("返回的json --->  "+json);
            br.close();
            return json;
        } catch (MalformedURLException ex) {
            Logger.getLogger(Translate_Youdao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Translate_Youdao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}


class Analysis_json{
    public String Analysis(String json) throws JSONException {

        //  返回的json --->
        //  {"translation":["我想念你"],"basic":{"explains":["我想你；思念（歌名）"]},"query":"I Miss You","errorCode":0,"web":[{"value":["我想你","思念","想念你朋友"],"key":"I miss you"},{"value":["我非常想念你","我非常的想念你"],"key":"I very miss you"},{"value":["我想飞"],"key":"i am miss you"}]}

        JSONObject jsonobj = new JSONObject(json);
        JSONArray jsonArray = (JSONArray) jsonobj.get("translation");
        String chinese_meaning = jsonArray.getString(0);
        System.err.println("中文意思是 :    " + chinese_meaning);
        return chinese_meaning;
    }
}