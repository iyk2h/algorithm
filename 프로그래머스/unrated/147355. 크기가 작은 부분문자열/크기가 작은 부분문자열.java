class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        for(int i = 0; i <= t.length() - p.length() ; i++) {
            String str = t.substring(i, i + p.length());
            
            long tmp = Long.parseLong(str);
            
            System.out.println(tmp);
            
            if(tmp <= Long.parseLong(p)){
                answer++;
            }
            
            
            
        }
        return answer;
    }
}