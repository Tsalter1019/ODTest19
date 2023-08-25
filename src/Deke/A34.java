package Deke;

import java.util.*;

/** 1.众数是指一组数据中出现次数多的数 众数可以是多个 2.中位数是指把一组数据从小到大排列，最中间的那个数， 如果这组数据的个数是奇数，那最中间那个就是中位数
如果这组数据的个数为偶数，那就把中间的两个数之和除以2就是中位数  3.查找整型数组中元素的众数并组成一个新的数组 求新数组的中位数
        输入描述
        输入一个一维整型数组，数组大小取值范围   0<n<1000  数组中每个元素取值范围，  0<e<1000
        输出描述
        输出众数组成的新数组的中位数
        示例一
        输入：
        10 11 21 19 21 17 21 16 21 18 16
        输出
        21
        示例二
        输入
        2 1 5 4 3 3 9 2 7 4 6 2 15 4 2 4
        输出
        3
        示例三
        输入
        5 1 5 3 5 2 5 5 7 6 7 3 7 11 7 55 7 9 98 9 17 9 15 9 9 1 39
        输出
        7       */
public class A34 {
    public static void main(String[] args) {
        //int[] arr={5,1,5,3,5,2,5,5,7,6,7,3,7,11,7,55,7,9,98,9,17,9,15,9,9,1,39};
        int[] arr={2,1,5,4,3,3,9,2,7,4,6,2,15,4,2,4};
        //int[] arr={10,11,21,19,21,17,21,16,21,18,16};
        System.out.println(solution(arr));
    }
    public static int solution(int[] arr){
        int result=0;
        List<Integer> list1 = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        List<Integer> list = new LinkedList<>(set);
        Collections.sort(list);
        Collections.reverse(list);
        int count=0;
        for(int i=0;i<list.size();i++){
            for(int j=0;j<arr.length;j++){
                if(list.get(i)==arr[j]){
                    count++;
                }
            }
            map.put(list.get(i),count);
            count=0;
        }
        Collection<Integer> c = map.values();
        Object[] ss = c.toArray();
        Arrays.sort(ss);
        int max = (int) ss[ss.length-1];
        Iterator<Integer> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            int key = iter.next();
            if(map.get(key)==max){
                list1.add(key);
            }
        }
        for(int i=0;i<list1.size();i++){
            if(list1.size()%2!=0){
                result = list1.get(list1.size()/2+1-1);
                break;
            }else{
                result = (list1.get(list1.size()/2-1)+list1.get(list1.size()/2+1-1))/2;
                break;
            }
        }
        return result;
    }
}