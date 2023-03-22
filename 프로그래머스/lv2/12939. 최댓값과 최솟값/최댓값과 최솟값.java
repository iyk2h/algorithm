import java.util.*;

class Solution {
    public String solution(String s) {
        int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        
        Arrays.sort(arr);

        String answer = "";
        answer += arr[0];
        answer += " ";
        answer += arr[arr.length - 1];


        return answer;
    }
}