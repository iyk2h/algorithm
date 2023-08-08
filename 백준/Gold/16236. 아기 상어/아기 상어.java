import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int max = Integer.MIN_VALUE;
    static int[][] arr;
    static boolean[][] visit;
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        visit = new boolean[n][n];

        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    q.offer(new Node(i, j, arr[i][j]));
                    visit[i][j] = true;
                    arr[i][j] = 0;
                }
            }
        }

        int eat = 0;
        int time = 0;
        int age = 2;

        while (true) {
            List<Node> fish = new LinkedList<>();
            int[][] dist = new int[n][n];

            while (!q.isEmpty()) {
                Node cur = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && dist[nx][ny] == 0
                            && arr[nx][ny] <= age) {
                        dist[nx][ny] = dist[cur.x][cur.y] + 1;
                        q.add(new Node(nx, ny, dist[nx][ny]));
                        if (1 <= arr[nx][ny] && arr[nx][ny] <= 6 && arr[nx][ny] < age) {
                            fish.add(new Node(nx, ny, dist[nx][ny]));
                        }
                    }
                }
            }

            if (fish.size() == 0) {
                System.out.println(time);
                return;
            }

            Node curFish = fish.get(0);
            for (int i = 1; i < fish.size(); i++) {
                if (curFish.dist > fish.get(i).dist) {
                    curFish = fish.get(i);
                } else if (curFish.dist == fish.get(i).dist) {
                    if (curFish.x > fish.get(i).x) {
                        curFish = fish.get(i);
                    } else if (curFish.x == fish.get(i).x) {
                        if (curFish.y > fish.get(i).y) {
                            curFish = fish.get(i);
                        }
                    }
                }
            }

            time += curFish.dist;
            eat++;
            arr[curFish.x][curFish.y] = 0;
            if (age == eat) {
                age++;
                eat = 0;
            }
            q.add(new Node(curFish.x, curFish.y, 0));
        }
    }

    static class Node {

        int x, y, dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}