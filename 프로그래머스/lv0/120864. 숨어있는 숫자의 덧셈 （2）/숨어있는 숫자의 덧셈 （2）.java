class Solution {

    public int solution(String my_string) {
        int answer = 0;

        for (int i = 0; i < my_string.length(); i++) {
            String c = String.valueOf(my_string.charAt(i));
            if (c.matches("[0-9]")) {
                String value = "";
                while (true) {
                    String wc = String.valueOf(my_string.charAt(i));
                    if (wc.matches("[0-9]")) {
                        value += wc;
                        i++;
                    } else {
                        break;
                    }
                    if (i >= my_string.length()) {
                        break;
                    }
                }
                if (value.length() != 0) {
                    answer += Integer.parseInt(value);
                }
            }
        }

        return answer;
    }
}