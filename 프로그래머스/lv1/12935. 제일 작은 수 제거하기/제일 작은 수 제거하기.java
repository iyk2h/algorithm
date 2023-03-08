import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length - 1 == 0){
            return new int[] {-1};
        }
        int min = Arrays.stream(arr).min().getAsInt();
               
        return         Arrays.stream(arr).filter(v -> v != min).toArray();
    }
}