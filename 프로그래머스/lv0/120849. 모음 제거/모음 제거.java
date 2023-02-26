class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        for(int i = 0; i < my_string.length(); i++){
            if(my_string.charAt(i) == 'i' || my_string.charAt(i) == 'o' || 
               my_string.charAt(i) == 'e' || my_string.charAt(i) == 'u' || my_string.charAt(i) == 'a'){
                continue;
            }
            answer += my_string.charAt(i);
        }
        
        return answer;
    }
}