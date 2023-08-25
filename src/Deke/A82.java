package Deke;

/*
  1.输入字符串s输出s中包含所有整数的最小和，
  说明：1字符串s只包含a~z,A~Z,+,-，
  2.合法的整数包括正整数，一个或者多个0-9组成，如：0,2,3,002,102
  3.负整数，负号开头，数字部分由一个或者多个0-9组成，如-2,-012,-23,-00023
  输入描述：包含数字的字符串
  输出描述：所有整数的最小和
  示例：
    输入：
      bb1234aa
  　输出
      10
  　输入：
      bb12-34aa
  　输出：
      -31
  说明：1+2-(34)=-31
   */
public class A82 {
    public static void main(String[] args) {
        System.out.println(solution("bb12-34aa"));
    }
    private static int solution(String s){
        int count=0;
        String status = "";
        StringBuilder temp= new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='-'){
                if(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'){
                    temp.append('-');
                }
            }
            if((s.charAt(i)>='A'&&s.charAt(i)<='Z')||(s.charAt(i)>='a'&&s.charAt(i)<='z')){
                if(!temp.toString().equals("")){
                    count+=Integer.parseInt(temp.toString());
                    temp=new StringBuilder();
                }
            }
            if(temp.length()==0){
                if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    count+=Integer.parseInt(s.charAt(i)+"");
                }
            }else{
                if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    temp.append(s.charAt(i));
                }

            }


        }

        return count;
    }
}