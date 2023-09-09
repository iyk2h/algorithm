import java.util.*;

class Solution {
    boolean visit[];
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visit = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                bfs(i, computers, n);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void bfs(int i, int[][] computers, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visit[i] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int j = 0; j < n; j++) {
                if (!visit[j] && computers[cur][j] == 1) {
                    visit[j] = true;
                    q.add(j);
                }
            }
        }
    }
}