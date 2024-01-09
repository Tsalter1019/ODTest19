package nowcoder.OD108;


import java.util.*;

public class HJ80 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int[] aa = new int[a];
        for(int i=0;i<aa.length;i++){
            aa[i] = in.nextInt();
        }
        int b = in.nextInt();
        int[] bb = new int[b];
        for(int i=0;i<bb.length;i++){
            bb[i] = in.nextInt();
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<aa.length;i++){
            set.add(aa[i]);
        }
        for(int i=0;i<bb.length;i++){
            set.add(bb[i]);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        String str = "";
        for(int i=0;i<list.size();i++){
            str+=list.get(i);
        }
        System.out.println(str);
    }
}