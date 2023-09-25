class Solution {
    boolean[] visit;
    int answer;
    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];
        answer = words.length;
        dfs(begin, target, words, 0);
        
        if (answer == words.length) {
            return 0;
        }
        
        return answer;
    }
    
    private void dfs(String begin, String target, String[] words, int depth) {
        if (begin.equals(target)) {
            answer = Math.min(answer, depth);
        }
        
        for (int i = 0; i < words.length; i++) {
            
            if ((visit[i])) continue;
            
            int diff = 0;
            for (int j = 0; j < target.length(); j++) {
                if (begin.charAt(j) != words[i].charAt(j)) {
                    diff++;
                }
            }
            if (diff == 1) {
                visit[i] = true;
                dfs(words[i], target, words, depth + 1);
                visit[i] = false;
            }
        }
    }
}