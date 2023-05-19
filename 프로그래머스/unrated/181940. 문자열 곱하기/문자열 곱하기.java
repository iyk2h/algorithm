class Solution {
    public String solution(String my_string, int k) {
        StringBuffer answer = new StringBuffer();
        while(k-->0){
            answer.append(my_string);
        }
        return answer.toString();
    }
}