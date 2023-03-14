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
                       
        if(count == 6){
            b = 1;
        }else if(count == 5){
            b = 2;
        }else if(count == 4){
            b = 3;
        }else if(count == 3){
            b = 4;
        }else if(count == 2){
            b = 5;
        }
        
        zeroCount += count;
        
                if(zeroCount == 6){
            a = 1;
        }else if(zeroCount == 5){
            a = 2;
        }else if(zeroCount == 4){
            a = 3;
        }else if(zeroCount == 3){
            a = 4;
        }else if(zeroCount == 2){
            a = 5;
        }
                
        int[] answer = {a, b};
        
        return answer;
    }
}