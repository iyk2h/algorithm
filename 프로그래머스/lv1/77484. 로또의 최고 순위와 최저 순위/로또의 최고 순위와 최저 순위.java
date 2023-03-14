class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;
        int zeroCount = 0;
        
        for(int lo : lottos){
            if(lo == 0){
                zeroCount++;
            }
            for(int win : win_nums){
                if(lo == win){
                    count++;
                }
            }
        }
        
        int a = 6;
        int b = 6;
                      
        if(count > 1){
            b = 7 - count;
        }
        
        zeroCount += count;
        
        if(zeroCount > 1){
            a = 7 - zeroCount;
        }
        
                
        int[] answer = {a, b};
        
        return answer;
    }
}