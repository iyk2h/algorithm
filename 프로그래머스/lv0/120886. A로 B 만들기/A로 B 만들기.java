import java.util.Arrays;

class Solution {

    public int solution(String before, String after) {

        char[] be = before.toCharArray();
        char[] af = after.toCharArray();

        Arrays.sort(be);
        Arrays.sort(af);

        if (new String(be).equals(new String(af))) {
            return 1;
        } else {
            return 0;
        }
    }
}