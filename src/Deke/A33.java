package Deke;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** 有一个简易内存池，内存按照大小粒度分类 每个粒度有若干个可用内存资源  用户会进行一系列内存申请  需要按需分配内存池中的资源   返回申请结果成功失败列表
分配规则如下
1.分配的内存要大于等于内存的申请量    存在满足需求的内存就必须分配  优先分配粒度小的，但内存不能拆分使用
2.需要按申请顺序分配   先申请的先分配，有可用内存分配则申请结果为true   没有可用则返回false    注释：不考虑内存释放
输入描述
输入为两行字符串
第一行为内存池资源列表 包含内存粒度数据信息，粒度数据间用逗号分割 一个粒度信息内用冒号分割 冒号前为内存粒度大小，冒号后为数量  资源列表不大于1024
个粒度的数量不大于4096
第二行为申请列表    申请的内存大小间用逗号分割，申请列表不大于100000

          如
          64:2,128:1,32:4,1:128
          50,36,64,128,127

          输出描述
          输出为内存池分配结果
          如true,true,true,false,false

          示例一：
          输入：
          64:2,128:1,32:4,1:128
          50,36,64,128,127
          输出：
          true,true,true,false,false

          说明:
          内存池资源包含：64k共2个、128k共1个、32k共4个、1k共128个的内存资源
          针对50,36,64,128,127的内存申请序列，
          分配的内存依次是，64,64,128,null,null
          第三次申请内存时已经将128分配出去，因此输出的结果是
          true,true,true,false,false
         */
public class A33 {
    public static void main(String[] args) {
        String a="64:2,128:1,32:4,1:128";
        String b = "50,36,64,128,127";
        System.out.println(solution(a,b));
    }
    public static String solution(String a,String b){
        StringBuilder stringBuilder = new StringBuilder();

        Map<Integer,Integer> map = new HashMap<>();
        String[] aa = a.split(",");
        String[] bb = b.split(",");
        boolean[] canDistribute = new boolean[bb.length];
        Arrays.fill(canDistribute,false);
        int[] bbArr = new int[bb.length];
        for(int i=0;i<bbArr.length;i++){
            bbArr[i] = Integer.parseInt(bb[i]);
        }
        for(int i=0;i<aa.length;i++){
            String[] temp = aa[i].split(":");
            map.put(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]));
        }
        for(int i=0;i<bbArr.length;i++){
            for(Integer key:map.keySet()){
                int value = map.get(key);
                if(value>=bbArr[i]&&value!=0){
                    map.put(key,value-1);
                    canDistribute[i] = true;
                    break;
                }
            }
        }
        for(int i=0;i<bbArr.length;i++){
            stringBuilder.append(canDistribute[i]);
            stringBuilder.append(",");
        }
        return stringBuilder.substring(0,stringBuilder.length()-1);
    }
}