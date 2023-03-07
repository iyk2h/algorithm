class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        String[] able = { "aya", "ye", "woo", "ma"};

        for(String str : babbling){
            for(String sub : able){
                str = str.replace(sub, " ");
            }
            if(str.isBlank()){
                answer++;
            }
        }

        return answer;
    }
}