import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        List<String> list = new ArrayList<>();
        
        for (int i : numbers) {
            list.add(String.valueOf(i));
        }
        
        Collections.sort(list, (o1, o2) -> {
            if (o1.charAt(0) == o2.charAt(0)) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
            return o2.charAt(0) - o1.charAt(0);
        });
        
        String answer = "";
        
        for (String s : list) {
            answer += s;
        }
        
        if (answer.charAt(0) == '0') {
            return "0";
        }
        
        return answer;
    }
}