package leetcodeDaily2024;

import java.util.Arrays;

public class B53 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//        int[][] intervals = {{1,4},{4,5}};
//        int[][] intervals = {{1,4},{0,4}};
        System.out.println(new B53().merge(intervals));
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2) -> o1[0]==o2[0] ? o1[1]-o2[1] : o1[0]-o2[0]);
        int temp=0;
        for(int i=0;i<intervals.length;i++){
            for(int j=0;j<intervals[i].length;j++){
                if(j==1){
                    temp = intervals[i][j];
                }else{
                    if(intervals[i][j]<=temp && i>0){
                        intervals[i][j] = intervals[i-1][0];
                        intervals[i-1][0] = 0;
                        intervals[i-1][1] = 0;
                        i--;
                        j--;
                        intervals = oldToNew(intervals);
                    }
                }
            }
        }
        return intervals;
    }
    public static int[][] oldToNew(int[][] old){
        int[][] ne = new int[old.length-1][old[0].length];
        for(int i=0;i<old.length;i++){
            for(int j=0;j<old[i].length;j++){
                if(old[i][j]!=0){
                    ne[i-1][0] = old[i][0];
                    ne[i-1][1] = old[i][1];
                }
            }
        }
        return ne;
    }
}
