class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        
        int idx = ((k - 1) * 2) % numbers.length;
        
        if(idx == 0){
            idx = numbers.length - 1;
        }
        
        return numbers[idx];
    }
}