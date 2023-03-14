import java.util.Arrays;

class Solution {

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            int[] tmp = Arrays.copyOfRange(score, 0, i + 1);
            Arrays.sort(tmp);
            int min = Integer.MAX_VALUE;
            for (int j = tmp.length - 1; j > tmp.length - k - 1 && j >= 0; j--) {
                min = Math.min(min, tmp[j]);
            }
            answer[i] = min;
        }

        return answer;
    }
}