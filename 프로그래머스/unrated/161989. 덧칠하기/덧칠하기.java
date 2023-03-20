class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        boolean[] wall = new boolean[n + m + 1];

        for (int i : section) {
            wall[i] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (wall[i]) {
                for (int j = 0; j < m; j++) {
                    wall[j] = false;
                }
                i += m - 1;
                answer++;
            }
        }

        return answer;
    }
}