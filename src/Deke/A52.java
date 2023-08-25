package Deke;

/**磁盘的容量单位有M,G,T这三个等级 他们之间的换算关系为 1T=1024G 1G=1024M 现在给定N块磁盘的容量 请对他们按从小到大的顺序进行稳定排序例如给定
5块盘容量 1T,20M,3G,10G6T,3M12G9M 排序后的结果为20M,3G,3M12G9M,1T,10G6T 注意单位可以重复出现 上述3M12G9M为 3M+12G+9M和 12M12G相等

    输入描述:
    输入第一行包含一个整数N 2<=N<=100 ,表示磁盘的个数 接下来的N行每行一个字符串 长度 (2<l<30) 表示磁盘的容量 有一个或多个格式为 mv的子串组成
    其中m表示容量大小 v表示容量单位
    例如 磁盘容量m的范围 1~1024正整数 容量单位v的范围包含题目中提到的M,G,T
    输出描述:
     输出N行
     表示N块磁盘容量排序后的结果
     示例1:
     输入
         3
         1G
         2G
         1024M

     输出
        1G
        1024M
        2G

    说明 1G和1024M容量相等,稳定排序要求保留他们原来的相对位置
    故1G在1024M前

     示例二:
     输入
          3
          2G4M
          3M2G
          1T

      输出
        3M2G
        2G4M
        1T
        说明1T大于2G4M大于3M2G

     */

public class A52 {
    public static void main(String[] args) {
        int m = 3;
        String[] arr = {"1G","2G","1024M"};
        solution(m,arr);
    }
    public static void solution(int m,String[] arr){
        for(int i=0;i<m-1;i++){
            if(compare(arr[i],arr[i+1])){
                String temp="";
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        if(compare(arr[arr.length-2],arr[arr.length-1])){
            String temp="";
            temp = arr[arr.length-2];
            arr[arr.length-2] = arr[arr.length-1];
            arr[arr.length-1] = temp;
        }
        for(int i=0;i<m;i++){
            System.out.println(arr[i]);
        }
    }

    public static boolean compare(String str1,String str2){
        if(transfer(str1)>transfer(str2)){
            return true;
        }else{
            return false;
        }
    }
    public static int transfer(String str){
        char[] ch1 = str.toCharArray();
        String temp="";
        int count=0;
        for(int i=0;i< ch1.length-1;i++){
            if(ch1[i]>='0'&&ch1[i]<='9'&&(ch1[i+1]!='M'||ch1[i+1]!='G'||ch1[i+1]!='T')){
                temp+=ch1[i];
            }
            if(ch1[i]=='M'){
                count+=Integer.parseInt(temp);
                temp="";
            }
            if(ch1[i]=='G'){
                count+=Integer.parseInt(temp)*1024;
                temp="";
            }
            if(ch1[i]=='T'){
                count+=Integer.parseInt(temp)*1024*1024;
                temp="";
            }
        }
        if(ch1[ch1.length-1]=='M'){
            count+=Integer.parseInt(temp);
        }
        if(ch1[ch1.length-1]=='G'){
            count+=Integer.parseInt(temp)*1024;
        }
        if(ch1[ch1.length-1]=='T'){
            count+=Integer.parseInt(temp)*1024*1024;
        }


        return count;
    }
    public static void swap(String str1,String str2){
        String temp="";
        temp = str1;
        str1 = str2;
        str2 = temp;
    }

}