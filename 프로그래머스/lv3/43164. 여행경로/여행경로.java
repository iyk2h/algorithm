import java.util.*;

class Solution {
    List<String> list;
    boolean[] visit;
    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];
        list = new ArrayList<>();
        
        dfs("ICN", "ICN", tickets, 0);
        
        Collections.sort(list);
        
        return list.get(0).split(" ");
    }
    
    private void dfs(String s, String route, String[][] tickets, int depth) {
        if (depth == tickets.length) {
            list.add(route);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(s) && !visit[i]) {
                visit[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, depth + 1);
                visit[i] = false;
            }
        }
    }
}