package leetcode;

//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
// 如果剩余字符少于 k 个，则将剩余字符全部反转。
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
// 示例 1：
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 示例 2：
//输入：s = "abcd", k = 2
//输出："bacd"
// 1 <= s.length <= 10⁴
// s 仅由小写英文组成
// 1 <= k <= 10⁴
public class A541 {
    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(new A541().reverseStr(s,2));
    }
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverse(arr, i, Math.min(i + k, n) - 1);
        }
        return new String(arr);
    }

    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}