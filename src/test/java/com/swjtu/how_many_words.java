package com.swjtu;

import org.junit.Test;

public class how_many_words {


    // 并且统计一共有多少个单词 (汉字除外)
    @Test
    public void Start() {
        String word = "abc cba";
        String[] arr = word.split("[^a-zA-Z0-9]+");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("There are " + arr.length + " words in the line!");
    }


}
