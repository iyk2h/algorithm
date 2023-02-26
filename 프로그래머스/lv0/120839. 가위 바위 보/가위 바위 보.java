import java.util.*;

class Solution {
    public String solution(String rsp) {
        String answer = "";
        
        HashMap<Character, String> map = new HashMap<Character, String>();
        
        map.put('2', "0");
        map.put('0', "5");
        map.put('5', "2");
        
        for (int i = 0; i < rsp.length(); i++) {
            answer += map.get(rsp.charAt(i));
        }
        return answer;
    }
}