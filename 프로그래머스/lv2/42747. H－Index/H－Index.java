import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for (int i = 1; i <= citations.length; i++) {
            for (int j = 0 ; j < citations.length; j++) {
                if (i <= citations[j]) {
                    if (i == citations.length - j) {
                        answer = i;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}