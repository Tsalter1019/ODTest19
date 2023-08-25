package Deke;
/** 停车场有一横排车位0代表没有停车,1代表有车. 至少停了一辆车在车位上,也至少有一个空位没有停车.
 为防止刮蹭,需为停车人找到一个车位 使得停车人的车最近的车辆的距离是最大的 返回此时的最大距离
       输入描述:
       1. 一个用半角逗号分割的停车标识字符串,停车标识为0或1, 0为空位,1为已停车
       2. 停车位最多有100个
       输出描述
       1. 输出一个整数记录最大距离

       示例一:
       输入
       1,0,0,0,0,1,0,0,1,0,1,0,0,1,1,0,0
       输出
       2

       说明
       当车停在第三个位置上时,离其最近的车距离为2(1~3)
       当车停在第四个位置上时,离其最近的车距离为2(4~6)
       其他位置距离为1
       因此最大距离为2
     */
public class A53 {
    public static void main(String[] args) {
        String s = "1,0,0,0,0,1,0,0,1,0,1,0,0,1,1,0,0";
        System.out.println(solution(s));
    }
    public static int solution(String s){
        int min=0;
        int temp=0;
        int left=1;
        int right=1;
        String[] strings = s.split(",");
        int len = strings.length;
        for(int i=0;i<len;i++){
            if(strings[i].equals("0")){
                int index = i;
                while(index-1>=0&&strings[index-1].equals("0")){
                    left++;
                    index--;
                }
                index = i;
                while(index+1<=len-1&&strings[index+1].equals("0")){
                    right++;
                    index++;
                }
                temp = Math.min(left,right);
                if(temp>min){
                    min = temp;
                }
            }
            right=1;
            left=1;

        }
        return min;
    }
}
