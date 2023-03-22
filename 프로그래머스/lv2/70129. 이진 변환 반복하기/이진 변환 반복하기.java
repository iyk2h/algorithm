class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int zero = 0;
        
        while(!s.equals("1")){
            int sLen = s.length();
            s = s.replace("0", "");
            zero += sLen - s.length();
            cnt++;
            s = Integer.toBinaryString(s.length());
        }
        
        int[] answer = {cnt, zero};
        
        return answer;
    }
}