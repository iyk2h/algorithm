import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] inputArr;
    static char[][] visited;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int cnt = 0;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열
        int R = Integer.parseInt(st.nextToken()); // 라운드 횟수

        inputArr = new int[N][M]; // 입력 배열
        visited = new char[N][M]; // 방문 여부 배열

        // 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                inputArr[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = 'S';
            }
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            String direction = st.nextToken();
            attack(x, y, getDir(direction));

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            defense(x, y);
        }

        System.out.println(cnt);
        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                System.out.print(visited[i][j]+" ");
            }
            System.out.println();
        }

    }

    static void attack(int x, int y, int dir) {
        if (visited[x][y] == 'F') {
            return;
        } else {
            int size = inputArr[x][y] - 1;
            visited[x][y] = 'F';
            cnt++;

            while (size > 0) {
                int nx = x + dr[dir];
                int ny = y + dc[dir];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    return;
                }
                if (visited[nx][ny] == 'F') {
                    size--;
                    x = nx;
                    y = ny;
                    continue;
                }
                size--;
                cnt++;
                visited[nx][ny] = 'F';
                x = nx;
                y = ny;

                int newSize = inputArr[nx][ny] - 1;
                size = Math.max(newSize, size);
            }
        }
    }

    static int getDir(String s) {
        if (s.equals("E")) {
            return 0;
        } else if (s.equals("W")) {
            return 1;
        } else if (s.equals("S")) {
            return 2;
        } else if (s.equals("N")) {
            return 3;
        }
        return 0;
    }

    static void defense(int x, int y) {
        if (visited[x][y] == 'F') {
            visited[x][y] = 'S';
        } else {
            return;
        }
    }
}