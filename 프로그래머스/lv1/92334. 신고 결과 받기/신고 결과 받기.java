import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Set<String>> idMap = new HashMap<>();
        Map<String, Set<String>> declarationMap = new HashMap<>();

        for (String id : id_list) {
            idMap.put(id, new HashSet<>());
            declarationMap.put(id, new HashSet<>());
        }

        for (String str : report) {
            String id = str.split(" ")[0];
            String declaration = str.split(" ")[1];

            idMap.get(id).add(declaration);
            declarationMap.get(declaration).add(id);
        }


        for (int i = 0; i < idMap.size(); i++) {

            int size = idMap.get(id_list[i]).size();

            for (String declaration : idMap.get(id_list[i])) {
                if (declarationMap.get(declaration).size() < k) {
                    size--;
                }
            }
            answer[i] = size;
        }

        return answer;
    }
}