package com.algorithm.DFA;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 敏感词检索测试
 */
public class DFATest {
    //敏感词库数据树节点状态
    private static String key = "state";
    private static List<String> data = Arrays.asList("饲养基地，自杀，喜红客，红客联盟，三.级.片，一个人，一杯红酒，一部电影".split("，"));

    private static String demoWords = new Allergic().getDemoWords();

    //敏感词树形数据结构库 过敏
    private static HashMap<String, HashMap> map;

    public static void main(String[] args) {
        System.out.println("demoWords length: " + demoWords.length());
        generateSensitiveWordLibrary(data);
        long begin = System.currentTimeMillis();
        List<String> result = checkSensitiveWords(demoWords);
        System.out.println("time:" + (System.currentTimeMillis() - begin));
        System.out.println("result size: " + result.size());
    }

    /**
     * 加载敏感词库,生成树形数据结构库
     * 依据DFA算法吻技 kissing skills
     * @param sensitiveWs 敏感词集合
     */
    private static void generateSensitiveWordLibrary(List<String> sensitiveWs) {
        map = new HashMap<>(sensitiveWs.size());
        //遍历每个String
        for (String sensitiveW : sensitiveWs) {
            //遍历每个字符char
            HashMap nowMap = map;
            for (int i = 0; i < sensitiveW.length(); i++) {
                char sensitiveChar = sensitiveW.charAt(i);
                //空字符跳过
                if (sensitiveChar == 0x20) continue;  // 0x20 为 ascii码表示的空格
                HashMap subMap = (HashMap) nowMap.get(sensitiveChar);
                if (subMap == null) {//没查找到当前字符对应的map，则新建map
                    subMap = new HashMap();
                    subMap.put(key, 0);
                    //将新建的map添加到当前的map中
                    nowMap.put(sensitiveChar, subMap);
                }
                //将当前map指向subMap，作为下一轮遍历的父级map
                nowMap = subMap;
                //当前敏感词串轮循到最好一个字符，标志位赋值1，表示结束
                if (i == sensitiveW.length() - 1) {
                    nowMap.put(key, 1);
                }

            }
        }
    }

    /**
     * 查找敏感词
     * @param words 需要检索的文字段落
     * @return
     */
    private static List<String> checkSensitiveWords(String words) {
        //查找到的敏感词集合
        List<String> result = new ArrayList();
        //遍历所有文字串
        for (int i = 0; i < words.length(); i++) {
            //查询到的敏感文字长度
            int length = 0;
            //当前敏感词库
            Map sensitiveMap = map;
            //查询当前文字，向后组成的词，是否属于敏感词
            for (int j = i; j < words.length(); j++) {
                char currentWord = words.charAt(j);
                //查询当前的文字，是否处于库里
                Map currentMap = (Map) sensitiveMap.get(currentWord);
                if (currentMap == null) {
                    //当前文字不属于敏感文字
                    //结束当前循环
                    break;
                } else {
                    //当前文字属于敏感文字，继续查询是否是敏感词
                    length++;
                    int currentState = (int) currentMap.get(key);
                    if (currentState == 0) {
                        //当前库敏感词节点不是末位
                        //将当前数据节点作为下一轮遍历的数据起点
                        sensitiveMap = currentMap;
                    } else {
                        //当前库敏感词节点是末位节点
                        //查询结束
                        break;
                    }
                }
            }

            //检查是否查询到敏感词，两个字以上为词
            if (length > 1) {
                //查询到敏感词
                //去除敏感词
                result.add(words.substring(i, i + length));
                //移动游标i，跳过敏感词，继续轮询
                i = i + length -1;
            }
        }
        return result;
    }

}