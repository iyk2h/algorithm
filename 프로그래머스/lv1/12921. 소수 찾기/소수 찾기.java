class Solution {
      
    public int solution(int n) {
        int answer = 1;
        
        for(int i = 3; i <= n; i++){
            boolean check = true;
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    check = false;
                    break;
                }
            }
            if(check){
                answer++;
            }
        }
        
        return answer;
    }
    
}