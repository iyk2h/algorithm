class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";

        for (String[] arr : db) {
            if (arr[0].equals(id_pw[0])) {
                answer = "wrong pw";
                if (arr[1].equals(id_pw[1])) {
                    answer = "login";
                    break;
                }
            }
        }

        return answer;
    }
}