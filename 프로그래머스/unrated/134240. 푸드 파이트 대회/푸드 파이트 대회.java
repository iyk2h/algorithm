class Solution {
    public String solution(int[] food) {
        String answer = "0";
        
        for(int i = food.length - 1; i > 0; i--){
            int j = food[i] / 2;
            
            String str = String.valueOf(i).repeat(j);
            
            answer = str + answer + str;
            
        }
        
        return answer;
    }
}