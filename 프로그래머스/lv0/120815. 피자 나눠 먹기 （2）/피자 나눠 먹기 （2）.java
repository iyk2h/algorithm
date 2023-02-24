class Solution {
    public int solution(int n) {
        int cnt = 1;
        while(true){
            if(n*cnt % 6 == 0){
                return n*cnt / 6;
            }
            cnt++;
        }
    }
}