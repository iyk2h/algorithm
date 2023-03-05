class Solution {

    public int solution(String s) {
        int answer = 0;

        String[] sr = s.split(" ");

        for (int i = 0; i < sr.length; i++) {
            String str = sr[i];
            if (str.equals("Z")) {
                answer -= Integer.parseInt(sr[i - 1]);
            } else {
                answer += Integer.parseInt(sr[i]);
            }
        }

        return answer;
    }
}