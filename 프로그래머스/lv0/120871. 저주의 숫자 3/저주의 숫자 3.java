class Solution {

    public int solution(int n) {
        int answer = 1;
        int i = 1;

        while (i != n) {
            answer++;

            while (true) {
                if (answer % 3 == 0) {
                    answer++;
                }
                else if (String.valueOf(answer).contains("3")) {
                    answer++;
                }
                else{
                    break;
                }
            }
            i++;
        }
        return answer;
    }
}