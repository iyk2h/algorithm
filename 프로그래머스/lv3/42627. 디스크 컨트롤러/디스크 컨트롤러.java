import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int cnt = 0;
        int jIdx = 0;
        int end = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        while (cnt < jobs.length) {
            while (jIdx < jobs.length && jobs[jIdx][0] <= end) {
                pq.add(jobs[jIdx++]);
            }
            
            if (pq.isEmpty()) {
                end = jobs[jIdx][0];
            }
            else {
                int[] cur = pq.poll();
                
                answer += cur[1] + end - cur[0];
                end += cur[1];
                cnt++;
            }
        }
        
        return (int) Math.floor(answer / jobs.length);
    }
}