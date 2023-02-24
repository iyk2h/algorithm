class Solution {
    public int solution(int[] array) {
        
        int answer = 0;
        int[] count = new int[1000];
        int max = 0;
        
        for(int i : array){
            count[i]++;
            
            if(max < count[i]){
                max = count[i];
                answer = i;
            }
        }
        
        int check = 0;
        for(int c : count){
            if(max == c){
                check++;
            }
        }
        if(check > 1){
            answer = -1;
        }

        return answer;
    }
}