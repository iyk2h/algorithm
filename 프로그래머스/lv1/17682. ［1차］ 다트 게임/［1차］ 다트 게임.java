class Solution {

    public int solution(String dartResult) {
        int answer = 0;


        int value = 0;
        int beforeValue = 0;
        for (int i = 0; i < dartResult.length(); i++) {            
            char c = dartResult.charAt(i);
            String str = "";
            if (c >= '0' && c <= '9') {
                answer += value;
                beforeValue = value;
                
                str = String.valueOf(c);
                if (c == '1') {
                    char nc = dartResult.charAt(i + 1);
                    if (nc >= '0' && nc <= '9') {
                        str += nc;
                        i++;
                    }
                }
                value = Integer.parseInt(str);
            }
            if (c == 'S') {
                continue;
            }
            if (c == 'D') {
                value = (int) Math.pow(value, 2);
            }
            if (c == 'T') {
                value = (int) Math.pow(value, 3);
            }
            if (c == '#') {
                value *= -1;
            }
            if (c == '*') {
                value *= 2;
                answer = answer + beforeValue;
            }
        }
        answer += value;
        return answer;
    }
}