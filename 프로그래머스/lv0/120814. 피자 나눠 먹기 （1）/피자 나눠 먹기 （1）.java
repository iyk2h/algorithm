class Solution {
    public int solution(int n) {
        int last = 1;
        if(n % 7 == 0) {
            last = 0;
        }
            
        int answer = (n / 7) + last;
        return answer;
    }
}