class Solution {

    public int solution(String s) {
        int answer = 1;

        char c = s.charAt(0);
        int cc = 1;
        int dc = 0;
        for (int i = 1; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                cc++;
            } else {
                dc++;
            }

            if (i == s.length() - 1) {
                break;
            }

            if (cc == dc) {
                answer++;
                c = s.charAt(i + 1);
            }
        }

        return answer;
    }
}