import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        
        my_string = my_string.replaceAll("[A-Z|a-z]","");
        
        int[] answer = new int[my_string.length()];
        for (int i = 0; i < my_string.length(); i++) {
            char c =  my_string.charAt(i);
            answer[i] = (int) c - '0';
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}