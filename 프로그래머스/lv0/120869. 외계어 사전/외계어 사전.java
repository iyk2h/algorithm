import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {

    public int solution(String[] spell, String[] dic) {
        Arrays.sort(spell);

        char[][] cc = new char[dic.length][10];
        String str = new String(Arrays.stream(spell).collect(Collectors.joining()));

        for (int i = 0; i < dic.length; i++) {
            cc[i] = dic[i].toCharArray();
            Arrays.sort(cc[i]);
        }

        for (char[] c : cc) {
            if (new String(c).equals(str)) {
                return 1;
            }
        }

        return 2;
    }
}