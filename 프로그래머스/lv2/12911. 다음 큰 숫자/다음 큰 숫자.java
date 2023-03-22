class Solution {
    public int solution(int n) {
        int answer = n + 1;
        int nCount = Integer.bitCount(n);      

        while(nCount != Integer.bitCount(answer)){
            answer++;
        }
        
        return answer;
    }
}