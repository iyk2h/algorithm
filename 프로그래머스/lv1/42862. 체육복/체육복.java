import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int count = 0;
        
        for(int j = 0; j < lost.length; j++){
            for(int i = 0; i < reserve.length; i++){
                if(lost[j] == reserve[i]){
                    reserve[i] = Integer.MIN_VALUE;
                    lost[j] = Integer.MIN_VALUE;
                    count++;
                    break;
                }
            }
        }
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int j = 0; j < lost.length; j++){
            for(int i = 0; i < reserve.length; i++){
                if(lost[j] - 1 == reserve[i] || lost[j] + 1 == reserve[i]){
                    reserve[i] = Integer.MIN_VALUE;
                    lost[j] = Integer.MIN_VALUE;
                    count++;
                    break;
                }
            }
        }
        
        return n - lost.length + count;
    }
}