import java.util.*;

class Solution {
    public int[] solution(String s) {

        List<Integer> list = new ArrayList<>();

        s = s.substring(2, s.length() - 2).replace("},{", "-");
        String[] arr= s.split("-");

        Arrays.sort(arr, (Comparator.comparingInt(String::length)));


        for (String str : arr) {
            String[] tmp = str.split(",");
            for (String tmpStr : tmp) {
                int i = Integer.parseInt(tmpStr);
                if (!list.contains(i)) {
                    list.add(i);
                }
            }
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}