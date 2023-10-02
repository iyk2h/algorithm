import java.util.*;

class Solution {
    int[] depth;
    List<List<Integer>> list = new ArrayList<>();
    public int solution(int n, int[][] edge) {
        depth = new int[n + 1];
        
        for (int i = 0 ;i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        int answer = 0;
        
        for (int[] i : edge) {
            int a = i[0];
            int b = i[1];
            
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        depth[1] = 1;
        
        int max = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i : list.get(cur)) {
                if (depth[i] == 0) {
                    q.add(i);
                    depth[i] = depth[cur] + 1;
                    if (max <= depth[i]) {
                        max = depth[i];
                    }
                }
            }
        }
        
        for (int i : depth) {
            if (i == max) {
                answer++;
            }
        }
        
        return answer;
    }
}