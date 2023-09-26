import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        int count = 0;
        int end = 0;
        int jobsIdx = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        while (count < jobs.length) {
            
            while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
                pq.add(jobs[jobsIdx++]);
            }
            
            if (pq.isEmpty()) {
                end = jobs[jobsIdx][0];
            } else {
                int[] cur = pq.poll();
                answer += cur[1] + end - cur[0];
                end += cur[1];
                count++;
            }
            
        }
        
        return (int) Math.floor(answer / jobs.length);
    }
}