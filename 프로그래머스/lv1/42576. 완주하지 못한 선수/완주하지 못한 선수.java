import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {

    public String solution(String[] participant, String[] completion) {
        StringBuilder answer = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();

        for (String str : participant) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (String str : completion) {
            map.put(str, map.getOrDefault(str, 0) - 1);
        }

        for (Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 1) {
                answer.append(entry.getKey());
            }
        }

        return answer.toString();
    }
}