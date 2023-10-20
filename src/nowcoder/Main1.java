package nowcoder;

import java.util.Stack;

/**
 * 做一个编程题    还原缩写的字符串
 * 输入：a(b(c)<3>)<2>d
 *  * 输出： abcccbcccd
 */

public class Main1 {
    public static String returnString(String s) {
        char[] ss = s.toCharArray();
        Stack<String> sCharacters = new Stack<>();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == '(') {
                continue;
            } else if (ss[i] >= 'a' && ss[i] <= 'z') {
                sCharacters.push(ss[i] + "");
            } else if (ss[i] == ')') {
                // 右括号拼接
                String temp = sCharacters.pop();
                // 找数字
                String number = "0";
                number = s.substring(s.indexOf("<", i) + 1, s.indexOf(">", i));

                int intNumber = Integer.parseInt(number);
                StringBuilder sb = new StringBuilder();
                sb.append(sCharacters.pop());
                for (int j = 0; j < intNumber; j++) {
                    sb.append(temp);
                }
                sCharacters.push(sb.toString());
            }
        }
        String result = "";
        while (!sCharacters.isEmpty()) {
            result = sCharacters.pop() + result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(returnString("a(b(c)<3>)<2>d"));

    }



}