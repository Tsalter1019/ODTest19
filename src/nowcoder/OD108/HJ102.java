package nowcoder.OD108;

import java.util.*;

/**
 * 输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出。
 * 一个只包含小写英文字母和数字的字符串。
 * 一个字符串，为不同字母出现次数的降序表示。若出现次数相同，则按ASCII码的升序输出
 * 输入：
 * aaddccdc
 * 输出：
 * cda
 * 说明：
 * 样例里，c和d出现3次，a出现2次，但c的ASCII码比d小，所以先输出c，再输出d，最后输出a.
 */
public class HJ102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<ch.length;i++){
            if(!map.keySet().contains(ch[i])){
                map.put(ch[i],1);
            }else{
                map.put(ch[i],map.get(ch[i])+1);
            }
        }
        List<Character> list = new ArrayList<>();
        for(char i:map.keySet()){
            list.add(i);
        }
        list.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if(map.get(o1)<map.get(o2)){
                    return 1;
                }else if(map.get(o1)==map.get(o2)){
                    return 0;
                }else{
                    return -1;
                }
            }
        });
        String a = "";
        for(int i=0;i<list.size();i++){
            a+=list.get(i);
        }
        System.out.println(a);

    }

}