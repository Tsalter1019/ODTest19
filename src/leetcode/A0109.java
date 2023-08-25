package leetcode;

//字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
// 示例1:
//  输入：s1 = "waterbottle", s2 = "erbottlewat"
// 输出：True
// 示例2:
//  输入：s1 = "aa", s2 = "aba"
// 输出：False
// 提示：
// 字符串长度在[0, 100000]范围内。
// 说明:
// 你能只调用一次检查子串的方法吗？


public class A0109 {
    public static void main(String[] args) {
        System.out.println(new A0109().isFlipedString("waterbottle","erbottlewat"));
    }
    public boolean isFlipedString(String s1, String s2) {
        int index=0;
        if(s1.equals("")&&s2.equals("")){
            return true;
        }
        for(int i=0;i<s2.length();i++){
            String former = s2.substring(index,i);
            String latter =s2.substring(i);
            String newString = latter+former;
            if(s1.equals(newString)){
                return true;
            }
        }
        return false;
    }
}