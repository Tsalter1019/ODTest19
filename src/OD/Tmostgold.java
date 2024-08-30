package OD;

import java.util.*;

public class Tmostgold {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int [] arr1 = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[][] arr2 = new int[N][N];
        for(int i=0;i<N;i++){
            arr2[i] = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(solution(N,arr1,arr2));

    }
    public static int solution(int N,int[] arr1,int[][] arr2){
        int count=0;
        Set<Integer> set = new HashSet<>();
        /*List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr1.length;i++){
            list.add(arr1[i]);
        }*/
        for(int i=0;i<arr2.length;i++){
            for(int j=0;j<arr2[i].length;j++){
                if(arr2[i][j]==1&&j!=i){
                    set.add(j);
                }
            }
        }

        List<Integer> list = new ArrayList<>(set);
        int a=0;
        for(int i=0;i<arr1.length;i++){
            if(list.contains(arr1[i])){
                a++;
            }
        }
        if(a==0){
            return 0;
        }
        for(int i=0;i<list.size();i++){
            for(int j=0;j<arr1.length;j++){
                if(list.get(i)==arr1[j]){
                    list.remove(i);
                    i=0;
                    break;
                }
            }
        }
        return list.size();
    }
}
