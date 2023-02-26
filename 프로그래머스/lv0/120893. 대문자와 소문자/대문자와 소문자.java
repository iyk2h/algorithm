class Solution {
    public String solution(String my_string) {
        String answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            
            if( c >= 'A' && c <= 'Z'){
                c = (char) (c + 32);
            } else{
                c = (char) (c - 32);
            }
            answer += c;
        }
        return answer;
    }
}