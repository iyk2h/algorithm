import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        
        
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i : numlist){
            if(i % n == 0){
                al.add(i);
            }
        }

        
        return al.stream().mapToInt(Integer::intValue).toArray();
    }
}