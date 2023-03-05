import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int solution(int[] array, int n) {
        int answer = 0;
        int gap = Integer.MAX_VALUE;

        Arrays.sort(array);
        
        for (int i : array) {
            int tmp = Math.abs(i - n);

            if (gap > tmp) {
                gap = tmp;
                answer = i;
            }
        }
        return answer;
    }
}