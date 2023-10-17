package leetcodeDaily;

/**
 *
 */
public class A2437 {
    public static void main(String[] args) {
        System.out.println(countTime("1234"));
    }
    public static int countTime(String time) {

        char[] ch = time.toCharArray();

        int count=0;

        for(int i=0;i<10;i++){
            StringBuffer stringBuffer = new StringBuffer();
            for(int j=0;j<ch.length;j++){
                if(ch[j]=='?'){
                    ch[j] = (char)i;
                    stringBuffer.append(ch[j]);
                }else{
                    stringBuffer.append(ch[j]);
                }
            }
            if(isLegal(stringBuffer.toString())){
                count++;
            }

        }

        return count;
    }
    public static boolean isLegal(String str){
        char[] ch = str.toCharArray();
        if(ch.length<=4){
            String num1 = ch[0]+""+ch[1];
            String num2 = ch[2]+""+ch[3];
            if(Integer.parseInt(num1)<=24&&Integer.parseInt(num2)<=60)
                return true;
            else
                return false;
        }else{
            return false;
        }

    }
}