import java.util.Arrays;

class Solution {
    public int[] solution(int n) {
        int[] divisors = new int[1];
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                if (count == divisors.length) {
                    divisors = Arrays.copyOf(divisors, count * 2);
                }
                divisors[count++] = i;
            }
        }

        divisors = Arrays.copyOf(divisors, count);
        Arrays.sort(divisors);

        return divisors;
    }
}