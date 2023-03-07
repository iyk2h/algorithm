class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        for(int l = 0 ; l < n ; l++){
            answer[l] = ((long) x * (l + 1));
        }
        
        return answer;
    }
}