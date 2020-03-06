package com.swjtu;

import com.swjtu.lang.LANG;
import com.swjtu.querier.Querier;
import com.swjtu.trans.AbstractTranslator;
import com.swjtu.trans.impl.GoogleTranslator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author YXB
 * @date 2020/2/14 15:44
 */
public class Translate_Google {
    // 翻译单词: miss (小姐)
    // 成功, 翻译只有'小姐'一个意思, 不全面           by 2020-02-10 12:06:09
    // 测试单词 miss Java JavaScript
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




}
