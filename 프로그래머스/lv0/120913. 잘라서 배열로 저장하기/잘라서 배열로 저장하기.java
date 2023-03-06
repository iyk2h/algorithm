import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String my_str, int n) {

        List<String> list = new ArrayList<>();

        int start = 0;

        for (int i = n; i <= my_str.length(); i += n) {
            list.add(my_str.substring(start, i));
            start = i;
            if (start == my_str.length()) {
                break;
            }
            if (i + n > my_str.length()) {
                list.add(my_str.substring(start));
                break;
            }
        }

        return list.toArray(new String[0]);
    }
}