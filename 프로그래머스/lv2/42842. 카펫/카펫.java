class Solution {
    public int[] solution(int brown, int yellow) {
        
        if(yellow == 1){
            return new int[] {3,3};
        }
        
        int row = 0;
        int column = 0;
        
        for(int i = 1; i <= yellow / 2; i++){
            if(yellow % i == 0){
                row = yellow / i;
                column = i;
                if(brown == (row * 2) + (column * 2) + 4 ){
                    break;
                }   
            }
        }
        
        int[] answer = {row + 2, column + 2};
        
        return answer;
    }
}