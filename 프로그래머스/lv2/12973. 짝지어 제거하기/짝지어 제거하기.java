import java.util.*;

class Solution
{
    public int solution(String s)
    {
        if(s.length() % 2 == 1)
            return 0;

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.add(c);
            }
        }

        if(stack.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }
}