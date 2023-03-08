class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String three = "";
        
        while(n > 0){
            three += n%3;
            n /= 3;
        }
               
        
        for(int i = 0; i < three.length(); i++){
            answer += Math.pow(3, i) * (three.charAt(three.length() - i - 1) - '0');
        }
        
        
        return answer;
    }
}