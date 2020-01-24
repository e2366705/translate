# 功能:
## 用Java实现翻译功能, 并且可以获取单词或英文句子的发音(以音频文件形式保存)

# 项目源地址:
## https://github.com/hujingshuang/MTrans

## 我只是在原作者的代码上自己加上了一些自己其他的东西

# 还有一种更加简单的方式来实现翻译功能:
### 这是直接爬取百度的翻译结果:
### use Java8 (Java1.8)
```java

    @Test
    public void Baidu_translate() {

        //  你要翻译的英文单词
        String english_words = "system";

        //这个就是博客中的java反射的url
        final String url = "https://www.baidu.com/baidu?wd=" + english_words + "&tn=monline_4_dg&ie=utf-8";
        // https://www.baidu.com/baidu?wd=system&tn=monline_4_dg&ie=utf-8


        try {
            //先获得的是整个页面的html标签页面
            Document doc = Jsoup.connect(url).get();

            //获取阅读数量
            //  class 是 .
            //  id    是 #
            Elements readEl = doc.select(".op_dict_text2");
            String read = readEl.text();
            System.out.println("========阅读数量=========：");
            System.out.println("阅读数量：" + read);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
```

## 运行环境:
### Java version : Java8 (Java1.8) 
### IDE : idea

#PS:
### Java11 好像运行不了, 少了个不知道什么鬼东西,我也不是很懂, 需要Java11运行的朋友, 自己去原作者项目地址问一下他, 原作者的项目地址放在上面了...
# ..嘤嘤嘤 QAQ...
# 怎么可以凶人家...面向Github编程有什么错咩...

