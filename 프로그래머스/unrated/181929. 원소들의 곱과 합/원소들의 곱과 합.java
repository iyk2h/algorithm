class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        int sum = 0;
        int multi = 1;
        
        for(int i : num_list){
            sum += i;
            multi *= i; 
        }
        
        sum *= sum;
        
        if(sum > multi){
            answer = 1;
        }
        
        return answer;
    }
}