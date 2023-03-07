class Solution {
    boolean solution(String s) {
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

        return a == 0;
    }
}