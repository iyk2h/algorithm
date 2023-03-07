class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        int aa = Math.min(a, b);
        int bb = Math.max(a, b);
        
        for(int i = aa; i <= bb; i++){
            answer += i;
        }
        
        return answer;
    }
}