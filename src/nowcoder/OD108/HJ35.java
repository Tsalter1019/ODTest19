package nowcoder.OD108;


import java.util.Scanner;

public class HJ35 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int[][] arr = new int[m][m];
        int t=1;
        for(int i=0;i<m;i++){
            arr[i] = new int[m-i];
            for(int j=0;j<i+1;j++){
                arr[i-j][j] = t;
                t++;
            }
        }

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length-1;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.print(arr[i][arr[i].length-1]);
            System.out.print("\n");
        }
    }
}
