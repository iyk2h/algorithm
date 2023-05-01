import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {

            Queue<Node> q = new LinkedList<>();
            Queue<Node>[] door = new Queue[26];

            int key[] = new int[26];
            int cnt = 0;

            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            char[][] board = new char[x + 2][y + 2];
            boolean[][] visited = new boolean[x + 2][y + 2];

            for (int i = 1; i <= x; i++) {
                String str = br.readLine();
                for (int j = 1; j <= y; j++) {
                    board[i][j] = str.charAt(j - 1);
                }
            }
            String keystr = br.readLine();

            for (char c : keystr.toCharArray()) {
                if (c == '0') {
                    continue;
                }
                key[c - 'a'] = 1;
            }

            for (int i = 0; i < 26; i++) {
                door[i] = new LinkedList<>();
            }

            q.offer(new Node(0, 0));
            visited[0][0] = true;

            while (!q.isEmpty()) {
                Node cur = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx < 0 || nx > x + 1 || ny < 0 || ny > y + 1) {
                        continue;
                    }
                    if (visited[nx][ny] || board[nx][ny] == '*') {
                        continue;
                    }
                    visited[nx][ny] = true;

                    // 1. 열쇠
                    if (board[nx][ny] >= 'a' && board[nx][ny] <= 'z') {
                        int k = board[nx][ny] - 'a';
                        key[k] = 1;
                        while (!door[k].isEmpty()) {
                            Node curDoor = door[k].poll();
                            q.offer(new Node(curDoor.x, curDoor.y));
                        }
                    }
                    // 2. 문
                    else if (board[nx][ny] >= 'A' && board[nx][ny] <= 'Z') {
                        int k = board[nx][ny] + 32 - 'a';
                        if (key[k] == 0) {
                            door[k].offer(new Node(nx, ny));
                            continue;
                        }
                    }
                    // 3. 문서
                    else if (board[nx][ny] == '$') {
                        cnt++;
                    }
                    q.offer(new Node(nx, ny));
                }
            }
            System.out.println(cnt);
        }
    }
}

class Node {

    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}