class Solution {
    public int solution(String num_str) {
        int answer = 0;
        String[] num_str_list = num_str.split("");
        for(int i = 0; i<num_str_list.length;i++){
            answer+=Integer.parseInt(num_str_list[i]);
        }
        return answer;
    }
}