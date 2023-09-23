import java.util.*;

class Solution {
    List<List<Integer>> map = new ArrayList<>();
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        for (int i = 0; i <= n ; i++) {
            map.add(new ArrayList<>());
        }
        
        for (int[]i : wires) {
            int a = i[0];
            int b = i[1];
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        
        for (int[]i : wires) {
            int a = i[0];
            int b = i[1];
            
            boolean[] visit = new boolean[n + 1];
            
            map.get(a).remove(Integer.valueOf(b));
            map.get(b).remove(Integer.valueOf(a));
            
            int cnt = dfs(1, visit);
            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, diff);
            
            map.get(a).add(b);
            map.get(b).add(a);
        }
        
        return answer;
    }
    
    private int dfs(int v, boolean[] visited) {
        visited[v] = true;
        int cnt = 1;
 
        for (int next : map.get(v)) {
            if (!visited[next]) {
                cnt += dfs(next, visited);
            }
        }
 
        return cnt;
    }
}