import java.util.Arrays;

class Solution {

    public String solution(String s) {
        String answer = "";

        int[] arr = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = 0;
        }

        char[] chars = s.toCharArray();

        Arrays.sort(chars);

        for (int i = 0; i < chars.length; i++) {
            int count = 0;
            for (int j = 0; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    count++;
                }
            }
            arr[i] = count;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                answer += chars[i];
            }
        }

        return answer;
    }
}