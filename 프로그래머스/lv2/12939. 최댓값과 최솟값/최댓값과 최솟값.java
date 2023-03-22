import java.util.*;

class Solution {
    public String solution(String s) {
        Integer[] arr = Arrays.stream(s.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        
        Arrays.sort(arr);

        String answer = "";
        answer += arr[0];
        answer += " ";
        answer += arr[arr.length - 1];


        return answer;
    }
}