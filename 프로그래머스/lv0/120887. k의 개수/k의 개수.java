class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;

        for(int s = i; s <= j; s++){
            String str = String.valueOf(s);
            for (char c : str.toCharArray()) {
                if((int) c - '0' == k ){
                    answer++;
                }
            }
        }
        return answer;
    }
}