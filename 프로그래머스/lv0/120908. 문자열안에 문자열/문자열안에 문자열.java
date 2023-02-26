class Solution {
    public int solution(String str1, String str2) {
        int answer = 2;

        int check = str1.length();

        str1 = str1.replace(str2, "");

        if(check != str1.length()){
            answer = 1;
        }


        return answer;
    }
}