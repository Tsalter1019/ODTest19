package leetcodeDaily;
//如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
// 操作 1：交换任意两个 现有 字符。
// 例如，abcde -> aecdb
// 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
// 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
// 你可以根据需要对任意一个字符串多次使用这两种操作。
// 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
// 示例 1：
//输入：word1 = "abc", word2 = "bca"
//输出：true
//解释：2 次操作从 word1 获得 word2 。
//执行操作 1："abc" -> "acb"
//执行操作 1："acb" -> "bca"
// 示例 2：
//输入：word1 = "a", word2 = "aa"
//输出：false
//解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
// 示例 3：
//输入：word1 = "cabbba", word2 = "abbccc"
//输出：true
//解释：3 次操作从 word1 获得 word2 。
//执行操作 1："cabbba" -> "caabbb"
//执行操作 2："caabbb" -> "baaccc"
//执行操作 2："baaccc" -> "abbccc"
// 示例 4：
//输入：word1 = "cabbba", word2 = "aabbss"
//输出：false
//解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
// 提示：
// 1 <= word1.length, word2.length <= 10⁵
// word1 和 word2 仅包含小写英文字母
// Related Topics 哈希表 字符串 排序 👍 113 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class M1657 {
    public static void main(String[] args) {
        System.out.println(new M1657().closeStrings("abc","bca"));//true
        System.out.println(new M1657().closeStrings("a","aa"));//false
        System.out.println(new M1657().closeStrings("cabbba","abbccc"));//true
        System.out.println(new M1657().closeStrings("cabbba","aabbss"));//false
        System.out.println(new M1657().closeStrings("abbzzca","babzzcz"));//false
        String a = "sftcfcfcfffffcsfctttttcticscttcfsccctsfissstfctscfctittfcscccitsscfcfcffsfcccccccfcicstffcscfiffffsffifctfscftfifccficfttcttsccccfffcffcfctccftcsfccfcscciscffscffscccffitciftsfcffctsccscitcffsificticcsicssffftcttfficctitcsffsccffiititfstcfsstfcttcccsfftficsfscccfsitcffccctcssccificcsssfctcffsctcccccccsccticctticcstciftsfftccctffcsiccffifiicttcfftifsstscffccifciccsicfttciffftctcfftsccctistcfccifsccssffcfcftffiicfsstcfccfccccsfccifcftffccctssccsisctcciitciciiffcsisticctcccsscsstfcftctftttcisccsstccctciccifcffffccfcffcscccfffficitcftcfscfttttccssticsftfcctiscfscssscftccisiccctitticisfcfccstscfcfffisccftctfcftcciccffcfccffctsfscfscitffifiscccsittsictfscfcfcccsifsfcccsctffsccsicsftficscsfiiccsfcfcsiifcccccccicfiftscssicccfttstcccfcsicctcciicifcccfftcftittstsctcfsffsitcicscficfccttcsticitciccctsciccstsctftcctsscctsfscicfcitciffcfcctcccftsiccscftcfcicfstsisfcscftctcictfcscsffctttiictcttssftscticftfscfsffcfscictctcsfcifftfiiitcficccfscstcstttscsiccticfcficccfcicttfficfctcicfffcsfttstfiitttsifcctcfcssfficfffsitscfcccsctiftitsscticiiftscfisfccccccccfcffccfcttiffsscscccfistccicfccstcicccisfcfcitcccfcfttfstccctfccstsisfcfsctsfscccisftsfsftscctsfssfcctcftcffscfccctfcictfccicfiicfsfccfccccttsicccffccccfctticssfstcccctfftccscfctfftsscscstciftcstscccccsicscsstcfttsfctsccstffffcccccffctcffcsfiisiffcftsstccfcticsicccsscccfsitsiicffcfscficctfcccctcstttcctccficffcccccfsctsctcfttccffccctcfctfscfcissccscfctfcffcccfffsfsficcffcctsfcctsccfcffscccftfttfscfftciictcscftsftttccctcfftccffctccstccffficcftcfccsfcftsfctcfsitcfftitctcffcccsccctfcsctfitcftcfcsftfsfccssctfffcfttffftccccctfcfisfcffccifctcitisfccffsscfccctcsftsisfttcsfffcsisiccscsfftcscccfcfstfcccctficsttfscctftcistcfsicsccttisccffcstcitcscftcsstccccictfftfccsfisttsffssisfsttttscstfccffittfcicicicfscfcficcfscsiffscficcffcccfcsctcctfffscitcccfcctccfccccicsftttffcfsccccctcffttcfcssccftffccccccctiicctcccctctsfffccfcsccftcctfcsiffcttffcfifcfccctftcccsccctcstfcccstsitftcctfctccftfcctittcccfcscffcfsitttctsffsftccifffcccfistffititccfcccccsiscscffcfccfcsfssfttiicfcctsftscccttftfsctfiiststfccsccccfcscscsstcscfcsfccttccttccfcsccccfsfcfcstfccfttciccfcsccscsfctsftsfcscfctctcccssscccsfsccfccftficccffftfftttcscifttcccctisccfftifffscfitfscssccsffttctccctf";
        String b = "csctisctsccscciificsiccscfctsfcissfsisfitittcscccifcccsicffcscccccistcccssfsscccssisiitscccsfftstcccsssstfcftssscitcsscciccscfcccicfciticciisssccsccifcicctttiicfsscfffffcfsstfcfcfcccicssccfcccsttccccfscictiicssiscccccsscccfitfscccifffcsscccitccfisftisfccscffciscisscccicfccffcsscsfsficcctiictisiccsiscisscffsissciicfcccccccfiiiscscssfsscfcicititcssssssssicsiiccicticssccccssstfscccscscfsfscscificcsfsssficstccctciiicscicfcsctfsifcccccicsccfcitsssccsicssfsisificstcscccifsifictisscfcciiicfttffscffcfsffcststcicccicicfccfcffscciiissscfciifscsifsctccsfficfcsciiictciccisifcsssssiiiicccsciitffccssssfifftftsccfsictccsicsiccccciscccsifscccfsssiffcctfstfccffsctsiscciscscfftccicccfiffiififtstfsssisfsscctcsttcitsfssisscistscccccifscciciiicfssfscfistftcssccctsfsstctscciicfsicficssicsscsccctsisctfcficftcisffffsssiiitstscsscccsiciscctcsiicsiccscciscfcfsccftstscccsciccistcsctiicsfsctfscitccffcitsticiciicfscsfcctcsctsscccfciiiicsssscsicstiisscttitciiscfstffcciccsiffsctciissfistfcciciicccsffsssfctstffcifscccisffffscccisccfccfccccscccfccsicscscccifcftssssftscicicfccctscstccccicsitsfffstcscsccisifsftccifccftcssicsfisccficsccccccccccssciccsicccfcittccssicstfccssctcfccscscccccicifsitcsccfifsftcsiccsciccccsficscciiscfcscstcciicftstifisfcsicsitcftcsiiftiiffscsticicssctcfcifststccisfctcfsfccssfiicttictcfsffcitccsccccsfscctfcttcsscscctfctsitcisicstfcciiiciscicicffctccficsssiscccfsiscfitsicifcsccicistsffctscccccsscctsiccfiiftcciffscccfcfstfcfscicscccscfccsccscssccssftitsctfctttcitcictstcifscsssstcctcficctsccisstcsittcftctcicfcctitcisssissccscscstsstscccississssfcfccfcissficsffccfcsiffsscfcscsictfcsficiccccsfccfcfsctitcciiiifstisttcfisciscicstcifccfsiitsfcifsfcciiicttsctsticsscifcccsccscccsiccsiccffccscccisisssfsfscccfisccccfciscsffiffcicicccffiitcsscfcfcicccfccfcscccssiccciccfccscfcccsccccscficfffcccfsscsfstcscitiscictcsfcstfcccsfifcsicsicsscsccsfcsfsccicssfsfcciciscfccccscsfsssfccififcicfcttccsiiccicfifstftiffsciitictctciciicctitisiisffccfccsiticccicfcstfccsicccscccfticssttcccfcsccctfscicicisicsctfscfcfsstccsscificsisstscfcctfffsscsscficcsscsfssccficitfccsciiisictiiccftcccfcctfssccifssccctccscsfctccicfcissscctscccccfsiiiccsisticccsciscificsfsffticcscficsicsffcfttfscsfsficsicitssiffcsscfisitcctctttctc";
        System.out.println(new M1657().closeStrings(a,b));//false
    }
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()){
            return false;
        }
        String str1 = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";

        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        for(int i=0;i<ch1.length;i++){
            if(!map1.keySet().contains(ch1[i])){
                map1.put(ch1[i],1);
            }else{
                map1.put(ch1[i],map1.get(ch1[i])+1);
            }
        }

        for(int i=0;i<ch2.length;i++){
            if(!map2.keySet().contains(ch2[i])){
                map2.put(ch2[i],1);
            }else{
                map2.put(ch2[i],map2.get(ch2[i])+1);
            }
        }
        char[] arr3 = new char[map1.size()];
        char[] arr4 = new char[map2.size()];
        int[] arr1 = new int[map1.size()];
        int[] arr2 = new int[map2.size()];

        int k=0;
        int l=0;
        for(char m: map1.keySet()){

            for(int i=k;i<map1.size();i++){
                arr1[i] = map1.get(m);
                arr3[i] = m;
                break;
            }
            k++;
        }
        for(char n: map2.keySet()){
            for(int i=l;i<map2.size();i++){
                arr2[i] = map2.get(n);
                arr4[i] = n;
                break;
            }
            l++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);
        Arrays.sort(arr4);
        for(int i=0;i<arr1.length;i++){
            str3+=arr1[i];
            str1+=arr3[i];
        }
        for(int i=0;i<arr2.length;i++){
            str4+=arr2[i];
            str2+=arr4[i];
        }

        if(str1.equals(str2) && str3.equals(str4)){
            return true;
        }else{
            return false;
        }
    }
}