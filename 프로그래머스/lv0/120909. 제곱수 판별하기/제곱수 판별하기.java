class Solution {
    public int solution(int n) {
        int answer = 2;
        int tmp = (int) Math.sqrt(n);
        if(Math.pow(tmp, 2) == n){
            answer = 1;
        } 
        
        return answer;
    }
}