class Solution {
    public String solution(String my_string) {
        String answer = "";

        String[] s = my_string.split("");

        for (int i = 0; i < s.length - 1; i++) {
            for (int j = i + 1; j < s.length; j++) {
                if (s[i].equals(s[j])){
                    s[j] = "";
                }
            }
        }

        return String.join("", s);
    }
}