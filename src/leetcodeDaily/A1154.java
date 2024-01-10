package leetcodeDaily;

//给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。返回该日期是当年的第几天。
// 示例 1：
//输入：date = "2019-01-09"
//输出：9
//解释：给定日期是2019年的第九天。
// 示例 2：
//输入：date = "2019-02-10"
//输出：41
// 提示：
// date.length == 10
// date[4] == date[7] == '-'，其他的 date[i] 都是数字
// date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日
//
// Related Topics 数学 字符串 👍 142 👎 0


public class A1154 {
    public static void main(String[] args) {
        System.out.println(new A1154().dayOfYear("2016-02-09"));
    }
    public int dayOfYear(String date) {
        String [] str = date.split("-");
        int year = Integer.parseInt(str[0]);
        int month = Integer.parseInt(str[1].charAt(0)=='0'?str[1].substring(1):str[1]);
        int day = Integer.parseInt(str[2].charAt(0)=='0'?str[2].substring(1):str[2]);

        int sum = 0;
        int [] arr = {31,28,31,30,31,30,31,31,30,31,30,31};
        for(int i=1;i<month;i++){
            sum+=arr[i-1];
        }
        sum+=day;
        if((year%4==0 && year%100!=0 && month>2)|| year%400==0 && month>2){
            sum+=1;
        }
        return sum;
    }
}