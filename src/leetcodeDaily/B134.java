package leetcodeDaily;

public class B134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0;i<gas.length;i++){
            int m=0,n=0;
            int res=0;
            while(m<gas.length&&n<cost.length){
                int a = m+i<gas.length?m+i:m+i-gas.length;
                int b = n+i<cost.length?n+i:n+i-cost.length;
                res+=gas[a];
                res-=cost[b];
                if(res<0){
                    break;
                }else{
                    m++;
                    n++;
                }
            }
            if(res<0){
                continue;
            }else{
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] gas = {4,5,2,6,5,3};
        int[] cost = {3,2,7,3,2,9};
        int pos = 3;
        System.out.println(new B134().canCompleteCircuit(gas,cost));
//        System.out.println(arrayFy(arr,pos));
    }

    /*public static int[] arrayFy(int[] old,int pos){
        int[] res = new int[old.length];
        for(int i=0;i<old.length;i++){
            if(pos+i<old.length){
                res[i] = old[pos+i];
            }else{
                res[i] = old[pos+i-old.length];
            }
        }
        return res;
    }*/
}
