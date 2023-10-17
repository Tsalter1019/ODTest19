package leetcodeDaily;

//给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
// 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含
//有大写和小写字母。
// 如果 a 和 b 相似，返回 true ；否则，返回 false 。
// 示例 1：
//输入：s = "book"
//输出：true
//解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
// 示例 2：
//输入：s = "textbook"
//输出：false
//解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
//注意，元音 o 在 b 中出现两次，记为 2 个。


public class A1704 {
    public static void main(String[] args) {
        System.out.println(new A1704().halvesAreAlike("book"));
    }
    public boolean halvesAreAlike(String s) {
        String a = s.substring(0,s.length()/2);
        String b = s.substring(s.length()/2);
        int count1=0;
        int count2=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)=='a'||a.charAt(i)=='e'||a.charAt(i)=='i'||a.charAt(i)=='o'||a.charAt(i)=='u'||a.charAt(i)=='A'||a.charAt(i)=='E'||a.charAt(i)=='I'||a.charAt(i)=='O'||a.charAt(i)=='U'){
                count1++;
            }
        }
        for(int j=0;j<b.length();j++){
            if(b.charAt(j)=='a'||b.charAt(j)=='e'||b.charAt(j)=='i'||b.charAt(j)=='o'||b.charAt(j)=='u'||b.charAt(j)=='A'||b.charAt(j)=='E'||b.charAt(j)=='I'||b.charAt(j)=='O'||b.charAt(j)=='U'){
                count2++;
            }
        }
        if(count1==count2){
            return true;
        }else{
            return false;
        }
    }
}