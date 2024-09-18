package leetcodeDaily2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B53 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(new B53().merge(intervals));
    }
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // 先对区间按照起始位置进行排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                // 有重叠，更新当前区间的结束位置
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // 无重叠，将当前区间添加到结果中，并更新当前区间为新的区间
                merged.add(current.clone());
                current = intervals[i];
            }
        }

        // 将最后一个区间添加到结果中
        merged.add(current.clone());

        // 将List转换为二维数组
        return merged.toArray(new int[merged.size()][]);
    }

}
