import java.util.*;

class Solution {
    boolean solution(String s) {
        
        int i = 0;
        
        for(char c : s.toCharArray()){
            if(c == '(')
                i++;
            else
                i--;
            if(i < 0)
                return false;
        }
        
        
        return i == 0;
    }
}