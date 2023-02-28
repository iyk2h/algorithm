class Solution {
    public int solution(int n) {
        int i = 1;
        int factorial = 1;
        
        while (factorial <= n) {
            i++;
            factorial *= i;
        }
        
        return i - 1;
    }
}
