class Solution {
    public int solution(int n, int m, int[] section) {
        int cur = section[0];
        int answer = 1;
        for(int i = 1; i < section.length; i++) {
            if(cur + m - 1 < section[i]) {
                answer++;
                cur = section[i];
            }
        }
        return answer;
    }
}