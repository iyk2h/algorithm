class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int arr = 0;
        int tmpX = x;
        
        while(tmpX > 0){
            arr += tmpX %10;
            tmpX /= 10;
        }
        
        
        return x % arr == 0;
    }
}