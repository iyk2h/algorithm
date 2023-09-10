import java.util.*;

class Solution {
    boolean[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visit = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visit[i]){
                dfs(computers, n, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int[][] computers, int n, int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visit[s] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int i = 0; i < n; i++) {
    	        if (!visit[i] && computers[cur][i] == 1) {
                    visit[i] = true;
                    q.add(i);
                }
	        }
        }
       
    }
}