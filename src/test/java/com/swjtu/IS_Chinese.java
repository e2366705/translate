package com.swjtu;


import org.junit.Test;

public class IS_Chinese {


    // 判断一个字符是否是中文
    public boolean isChinese__(char c) {
        return c >= 0x4E00 &&  c <= 0x9FA5;// 根据字节码判断
    }


    // 判断一个字符串是否含有中文
    @Test
    public void isChinese() {
        String str = "my friends gardens and we’ve become closer 哈哈哈哈哈 ";

        if (str == null){
        }
        for (char c : str.toCharArray()) {
            if (isChinese(c)) {
                // 有多少个汉字 , 就输出多少个
                System.out.println("含有中文");
            }
        }
    }


    @Test
    public void isChinese_(){

        String world_1 = "asdasd";
        String world_2 = "阿";

        for (char c : world_2.toCharArray()) {
            if (isChinese(c)) {
                System.out.println("含有中文");
            }
        }
    }

    @Test
    public void test01() {
        String str = "my friends gardens and we’ve become closer";

        if (str.getBytes().length == str.length()) {
            System.err.println("english....");
        }else {
            System.err.println("those string has chinese....");
        }
    }

    @Test
    public void IS_has_blank_space(){
        String str = "acd dd";
        if(str.contains(" ")){
            System.out.println("存在空格 , 是一个句子");
        }else{
            System.out.println("没有 空格");
        }
    }





    // 判断一个字符是否是中文
    public boolean isChinese(char c) {
        return c >= 0x4E00 &&  c <= 0x9FA5;// 根据字节码判断
    }


    @Test
    public void aaa(){
        System.out.println("Method isChinese_() should be void  返回值必须是 void ...");
    }
}



