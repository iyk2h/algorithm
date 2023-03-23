import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        
        for(int i = 0 ; i < s.length(); i++){
            Stack<Character> stack = new Stack<>();
            
            for(char c : s.toCharArray()){
                if(!stack.isEmpty() && ( stack.peek() == (char)(c-2) || stack.peek() == (char)(c-1)) ) {
                    stack.pop();
                }else{
                    stack.add(c);
                }
            }
            
            char tmp = s.charAt(0);
            s = s.substring(1) + tmp;
            
            if(stack.isEmpty()){
                answer++;
            }
        }
        
        return answer;
    }
}