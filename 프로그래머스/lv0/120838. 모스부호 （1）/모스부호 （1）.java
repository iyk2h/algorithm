import java.util.*;


class Solution {
    public String solution(String letter) {
        String answer = "";
        List<String> morseList = Arrays.asList(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..");

        String[] input = letter.split(" ");

        for(String s : input){
            answer += (char)(morseList.indexOf(s) + 'a');
        }

        return answer.toString();
    }
}