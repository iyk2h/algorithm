import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        int[] tmp = new int[100];
        int idx = 0;
        for (int i = 0; i < my_string.length(); i++) {
            char c =  my_string.charAt(i);
            if(c <= '9' && c >= '0'){
                tmp[idx] = (int) c - '0';
                idx ++;
            }
        }

        int[] answer = new int[idx];
        
        for (int i = 0; i < idx; i++) {
            answer[i] = tmp[i];
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}