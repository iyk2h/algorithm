import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] state;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine());

        while (t-->0) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[n+1];
            state = new int[n+1];
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                state[i] = 0;
            }
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (state[i] == 0) {
                    run(i);
                }
            }
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (state[i] != -1) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

    static void run(int i) {
        int cur = i;
        while (true) {
            state[cur] = i;
            cur = arr[cur];
            // 이번 방문에서 지나간 학생에 도달했을 경우
            if (state[cur] == i) {
                while (state[cur] != -1) {
                    state[cur] = -1;
                    cur = arr[cur];
                }
                return;
            }
            // 이전 방문에서 지나간 학생에 도달
            else if (state[cur] != 0) {
                return;
            }
        }
    }
}