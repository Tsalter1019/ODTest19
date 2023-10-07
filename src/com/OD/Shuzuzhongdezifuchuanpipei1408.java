package com.OD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组中的字符串匹配
 * 给你一个字符串数组 words ，数组中的每个字符串都可以看作
 * 是一个单词。请你按 任意 顺序返回 words 中是其他单词的
 * 子字符串的所有单词。
 *如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到
 *  word[i] ，那么字符串 words[i] 就是 words[j] 的一个
 *  子字符串。
 *
 */
public class Shuzuzhongdezifuchuanpipei1408 {
    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();
        Arrays.sort(words, (s1, s2) -> {return s1.length() - s2.length();});

        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(words[j].indexOf(words[i]) >= 0){
                    list.add(words[i]);
                    break;
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println("abc".contains("bc"));
    }
}