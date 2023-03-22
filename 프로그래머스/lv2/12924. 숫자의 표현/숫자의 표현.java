class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++){
            int sum = i;
            int j = i + 1;
            while(sum <= n){
                if(sum == n){
                    answer++;
                    break;
                }
                sum += j;
                j++;
            }
        }
        
        return answer;
    }
}