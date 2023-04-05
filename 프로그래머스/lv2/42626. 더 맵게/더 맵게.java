import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        //우선순위 큐 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville){
            pq.add(i);
        }
        
        //스코빌 지수가 K 이상
        while(pq.peek() < K){
            // 스코빌 지수를 K 이상으로 만들 수 없는 경우
            if(pq.size() == 1){
               return -1;
            // else pq.add( poll() + poll() * 2 )
            }else{
                answer++;
                pq.add(pq.poll() + pq.poll() * 2);
            }
        }
        return answer;
    }
}