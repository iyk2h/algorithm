import java.util.*;

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {        
        for(int i = 0; i < signs.length; i++){
            if(!signs[i]){
                absolutes[i] *= -1;
            }
        }

        return Arrays.stream(absolutes).sum();
    }
}