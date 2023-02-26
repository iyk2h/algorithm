class Solution {
    public String solution(int age) {
        String answer = "";
        String s = String.valueOf(age);
        
        for(int i = 0; i<s.length(); i++){
            answer += (char)('a' + (int) s.charAt(i) - '0');
        }
        
        return answer;
    }
}