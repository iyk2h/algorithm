class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        int[] line = new int[201];
        
        for(int[] i : lines){
            i[0] += 100;
            i[1] += 100;
            
            for(int j = i[0] ; j <i[1] ; j++){
                line[j]++;
            }
        }    
        
        for(int i : line){
            if(i > 1){
                answer ++;   
            }
        }
        
        
        return answer;
    }
}