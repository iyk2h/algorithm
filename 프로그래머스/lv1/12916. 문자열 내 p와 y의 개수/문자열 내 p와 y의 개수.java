class Solution {
    boolean solution(String s) {
        boolean answer = true;

        s = s.toLowerCase();

        int a = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p') {
                a++;
            }
            if (s.charAt(i) == 'y') {
                a--;
            }
        }

        if (a != 0) {
            return false;
        }

        return answer;
    }
}