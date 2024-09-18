package leetcodeDaily2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class B49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> list = new ArrayList<>(Arrays.stream(strs).
                collect(Collectors.groupingBy(s -> Arrays.toString(
                        s.codePoints().sorted().toArray()))).values());
        return list;
    }
}
