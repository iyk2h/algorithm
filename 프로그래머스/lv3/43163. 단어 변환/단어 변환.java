class Solution {
    boolean[] visit;
    int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {

        visit = new boolean[words.length];
        dfs(words, begin, target, 0);

        if (answer == Integer.MAX_VALUE) {
            return 0;
        }
        return answer;
    }

    private void dfs(String[] words, String cur, String target, int cnt) {

        if(cur.equals(target)) {
            if (cnt < answer) {
                answer = cnt;
            }

            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visit[i]) continue;
            int k = 0;
            for (int j = 0; j < cur.length(); j++) {
                if (cur.charAt(j) != words[i].charAt(j)) {
                    k++;
                }
            }
            if (k == 1) {
                visit[i] = true;
                dfs(words, words[i], target, cnt + 1);
                visit[i] = false;
            }
        }
    }
}