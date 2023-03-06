class Solution {
    public int solution(String my_string) {

        String[] str = my_string.split(" ");

        int answer = Integer.parseInt(str[0]);

        for (int i = 0; i < str.length; i++) {
            if (i % 2 == 1){
                if (str[i].equals("+")) {
                    i++;
                    answer += Integer.parseInt(str[i]);
                } else if (str[i].equals("-")) {
                    i++;
                    answer -= Integer.parseInt(str[i]);
                }
            }
        }

        return Math.abs(answer);
    }
}