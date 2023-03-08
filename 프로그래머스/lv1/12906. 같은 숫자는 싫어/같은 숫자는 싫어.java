import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();

        int tmp = -1;
        for(int i : arr){
            if(tmp != i){
                list.add(i);
                tmp = i;
            }
        }


        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}