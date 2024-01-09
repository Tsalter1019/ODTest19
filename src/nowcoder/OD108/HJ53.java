package nowcoder.OD108;


import java.util.Scanner;

public class HJ53 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);



        while (in.hasNextInt()) {
            int num = in.nextInt();
            if(num == 1 || num == 2){
                System.out.println(-1);
                continue;
            }
            else if(num % 4 == 1 || num % 4 == 3){
                System.out.println(2);
                continue;
            }
            else if(num % 4 == 0){
                System.out.println(3);
                continue;
            }
            else if(num % 4 == 2){
                System.out.println(4);
                continue;
            }
        }
        /*List<Integer> listRes = new ArrayList<>();

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0;i<numRows;i++){
            List<Integer> list = new ArrayList<>();
            int row =i+1;
            for(int j=0;j<row;j++){
                if(j == 0 || j == row-1){
                    list.add(1);
                }else{
                    List<Integer> pre = res.get(i-1);
                    int num = pre.get(j) + pre.get(j-1);
                    list.add(num);
                }
            }
            res.add(list);
        }
        listRes = res.get(res.size()-1);

        for(int i=0;i<listRes.size();i++){
            if(listRes.get(i)%2==0){
                System.out.println(i+1);
                break;
            }
        }*/
    }
}
