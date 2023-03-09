import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        int sum = 0;
        int answer = 0;
        
        for(int i = 0; i < d.length ; i++){
            sum += d[i];
            if(sum > budget){
                break;
            }
            answer = i + 1;
        }
        
        return answer;
    }
}