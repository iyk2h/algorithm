import java.util.Arrays;
import java.util.stream.*;

class Solution {
    public int[] solution(int n) {
        return Arrays.stream(getDivisors(n))
                .sorted()
                .toArray();
    }

    private int[] getDivisors(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(i -> n % i == 0)
                .toArray();
    }
}
