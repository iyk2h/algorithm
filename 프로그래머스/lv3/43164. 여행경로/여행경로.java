import java.util.*;

class Solution {
    List<String> list;
    boolean[] visit;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
		list = new ArrayList<>();
        visit = new boolean[tickets.length];
        
        dfs("ICN", "ICN", tickets, 0);
        
        Collections.sort(list);
        
        answer = list.get(0).split(" ");
        
		return answer;
    }
    
    private void dfs(String s, String route, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            list.add(route);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (s.equals(tickets[i][0]) && !visit[i]) {
                visit[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt + 1);
                visit[i] = false;
            }
        }
    }
}