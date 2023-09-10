import java.util.*;

class Solution {
    int[] dx = new int[]{0,0,-1,1};
    int[] dy = new int[]{-1,1,0,0};

    int n, m;

    public int solution(int[][] maps) {
        int answer = -1;

        n = maps.length;
        m = maps[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        int[][] dist = new int[n][m];

        dist[0][0] = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            if (cx == n - 1 && cy == m - 1) {
                return dist[cx][cy];
            }

            for (int k = 0; k < 4; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];

                if (oob(nx, ny)) {
                    continue;
                }
                if (dist[nx][ny] == 0 && maps[nx][ny] == 1) {
                    q.add(new int[]{nx, ny});
                    dist[nx][ny] = dist[cx][cy] + 1;
                }
            }
        }

        return answer;
    }

    private boolean oob(int x, int y){
        return x < 0 || y < 0 || x >= n || y >= m;
    }
}