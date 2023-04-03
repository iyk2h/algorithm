class Solution {

    static boolean[] visited;
    static int max = 0;

    void dfs(int k, int[][] dungeons, int cnt) {
        // 모든 케이스 순회
        for (int i = 0; i < dungeons.length; i++) {
            int a = dungeons[i][0];
            int b = dungeons[i][1];

            // 기존에 방분 확인, 최소 피로도 확인
            if (visited[i] || k < a) {
                continue;
            }

            // 방문
            visited[i] = true;
            dfs(k - b, dungeons, cnt + 1);
            // 다른 케이스를 위해 방문 취소
            visited[i] = false;
        }
        max = Math.max(max, cnt);
    }

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        dfs(k, dungeons, 0);
        return max;
    }
}