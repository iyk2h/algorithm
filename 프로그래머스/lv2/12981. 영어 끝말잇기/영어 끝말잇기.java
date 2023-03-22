import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();
        int idx = 0;
        list.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (!list.contains(words[i])) {
                String beforeWord = list.get(idx);
                if (beforeWord.charAt(beforeWord.length() - 1) != words[i].charAt(0)) {
                    return fail(n, i);
                }
                idx++;
                list.add(words[i]);
            } else {
                return fail(n, i);
            }
        }

        return new int[] {0, 0};
    }

    private static int[] fail(int n, int i) {
        int order = (i / n) + 1;
        int num = (i % n) + 1;
        return new int[] {num, order};
    }

}