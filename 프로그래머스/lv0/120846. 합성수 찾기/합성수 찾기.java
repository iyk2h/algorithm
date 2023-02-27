class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 4; i <= n ; i++){
            int div = 0;
            for(int j = 1; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    if(j * j == i){
                        div++;
                    } else{
                        div += 2;
                    }
                }
            }
            if(div >= 3){
                answer++;
            }
        }
        
        return answer;
    }
}