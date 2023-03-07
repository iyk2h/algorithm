import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();

        for(int i : arr){
            if(i % divisor == 0){
                list.add(i);
            }
        }
        
        if(list.isEmpty()){
            list.add(-1);
        }

        return list.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}