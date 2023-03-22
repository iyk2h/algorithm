class Solution {
    public String solution(String s) {
        String answer = "";

        char[] arr = s.toCharArray();

        answer += String.valueOf(arr[0]).toUpperCase();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == ' ') {
                answer += String.valueOf(arr[i]).toUpperCase();
                continue;
            } else {
                answer += String.valueOf(arr[i]).toLowerCase();
            } 
        }

        return answer;
    }
}