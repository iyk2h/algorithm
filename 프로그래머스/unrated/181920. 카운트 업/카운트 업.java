class Solution {
    public int[] solution(int start, int end) {
        int n = end - start + 1;
        int[] answer = new int[n];
        for(int i = 0; i < n ; i++){
            answer[i] = i + start;
        }
        return answer;
    }
}