class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        for (int i = -(num + total); i <= (num + total) ; i++){
            int sum = 0;
            int idx = 0;
            
            for(int j = i ; j < i + num ; j++){
                answer[idx] = j;
                sum += j;
                idx++;
            }
            
            if (sum == total){
                return answer;
            }
        }
        
        return answer;
    }
}