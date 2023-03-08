class Solution {
    public long solution(int price, int money, int count) {      
        long sum = 0;
        
        for(int i = 1; i <= count; i++){
            sum += price * i;
        }

        if(money >= sum){
            return 0;
        }
        
        return sum - money;
    }
}