import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5}; // 5
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10

        int[] count = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % 5]) {
                count[0]++;
            }
            if (answers[i] == two[i % 8]) {
                count[1]++;
            }
            if (answers[i] == three[i % 10]) {
                count[2]++;
            }
        }

        int max = Math.max(count[0], Math.max(count[1], count[2]));

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                list.add(i + 1);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}