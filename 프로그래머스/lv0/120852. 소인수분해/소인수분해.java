import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n) {
        Set<Integer> set = new HashSet<>();

        for (int i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                set.add(i);
                n /= i;
            }
        }

        if (n != 1) {
            set.add(n);
        }

        int[] arr = set.stream().mapToInt(Integer::intValue).toArray();

        Arrays.sort(arr);

        return arr;
    }
}