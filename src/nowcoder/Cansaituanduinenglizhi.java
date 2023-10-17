package nowcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 用数组代表每个人的能力
 * 一个活动比赛要求参赛团队的最低能力值为N，每个团队可以由一人或者两个人组成
 * 且一个人只能参加一个团队
 * 计算出最多可以派出复合要求的队伍
 *
 * 输入
 * 5                     总人数
 * 3 1 5 7 9             每个人的能力
 * 8                     团队要求的最低能力值
 *
 * 输出
 * n
 */

public class Cansaituanduinenglizhi {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] nums = in.nextLine().split(" ");
        int base = Integer.parseInt(in.nextLine());
        in.close();
        System.out.println(solution(n,nums,base));

    }

    public static int solution(int n,String[] nums,int base){
        Integer[] list = Arrays.stream(nums)
                .map(Integer::parseInt)//返回由将给定函数应用于此流的元素的结果组成的流。
                .filter(x -> x < base)//返回由与给定谓词匹配的此流的元素组成的流。（过滤出小于最低能力值的用于后面的循环组队）
                .sorted()//返回由该流的元素组成的流，按自然顺序排序。如果该流的元素不是 {@code Comparable}，则在执行终端操作时可能会抛出 {@code java.lang.ClassCastException}。
                .toArray(Integer[]::new);//返回一个包含此流元素的数组，使用提供的 {@code generator} 函数分配返回的数组，以及分区执行或调整大小可能需要的任何其他数组。

        int count = nums.length - list.length;//设定团队数初始值为 总人数-小于能力值的人数（即大于等于最低能力值的为初始值）

        int i = 0, j = list.length - 1;
        while (i < j) {
            if (list[i] + list[j] >= base) {//尽可能满足最多  把最大的和最小的相加如果大于最低能力值  队伍数+1
                count++;
                i++;
                j--;
            } else i++;//如果最大和最小的相加都不满足 则把i++ 拿最大的和第二个相加
        }
        //System.out.println(count);
        return count;
    }
}