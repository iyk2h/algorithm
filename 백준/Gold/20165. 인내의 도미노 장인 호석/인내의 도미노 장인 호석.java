import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        inputArr = new int[N + 1][M + 1]; // 입력 배열
        visited = new char[N + 1][M + 1]; // 방문 여부 배열

        // 입력 받기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                inputArr[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = 'S'; // 모든 칸을 방문하지 않은 상태로 초기화
            }
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            attack(x, y, getDir(direction));

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            defense(x, y);
        }

        System.out.println(cnt);
        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= M ; j++) {
                System.out.print(visited[i][j]+" ");
            }
            System.out.println();
        }

    }

    static void attack(int x, int y, int dir) {
        if (visited[x][y] == 'F') { // 이미 방문한 칸이면 종료
            return;
        } else {
            int size = inputArr[x][y] - 1;
            visited[x][y] = 'F';  // 방문 표시
            cnt++; // 방문 횟수 증가

            while (size > 0) {
                int nx = x + dr[dir];
                int ny = y + dc[dir];
                // 경계를 벗어난 경우 종료
                if (nx < 1 || nx >= N + 1 || ny < 1 || ny >= M + 1) {
                    return;
                }
                size--;
                x = nx;
                y = ny;
                // 이미 방문한 칸
                if (visited[nx][ny] == 'F') {
                    continue;
                }
                // 방문하지 않은 칸
                visited[nx][ny] = 'F';

                // 새로 방문한 곳과 기존 도미노 사이즈 비교
                size = Math.max(size, inputArr[nx][ny] - 1);

                //방문 횟수 증가
                cnt++;
            }
        }
    }

    // 방향 별 값
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

    // 뒤집기
    static void defense(int cr, int cc) {
        if (visited[cr][cc] == 'F') {
            visited[cr][cc] = 'S';
        } else {
            return;
        }
    }
}