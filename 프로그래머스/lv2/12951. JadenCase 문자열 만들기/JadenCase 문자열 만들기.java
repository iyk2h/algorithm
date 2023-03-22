class Solution {
    public String solution(String s) {
        String answer = "";

        String[] arr = s.toLowerCase().split("");

        boolean flag = true;

        for (String str : arr) {
            if (flag) {
                str = str.toUpperCase();
            }
            answer += str;
            if(str.equals(" ")){
                flag = true;
            }else{
                flag = false;
            }
        }

        return answer;
    }
}