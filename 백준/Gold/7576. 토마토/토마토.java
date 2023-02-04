import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static ArrayList<ArrayList<Integer>> map;
    static int x;
    static int y;
    static int d = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        x = read();
        y = read();

        map = new ArrayList<>();

        for (int i = 0; i < y; i++) {
            map.add(new ArrayList<>());

            for (int j = 0; j < x; j++) {
                map.get(i).add(read());
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (map.get(i).get(j) == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }
        bfs();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                int t = map.get(i).get(j);
                if (t == 0) {
                    System.out.println("-1");
                    return;
                }
                max = Math.max(max, t);
            }
        }

        System.out.println(max - 1);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int inY = t[0];
            int inX = t[1];

            for (int i = 0; i < 4; i++) {
                int ny = inY + dy[i];
                int nx = inX + dx[i];

                if (nx >= 0 && ny >= 0 && nx < x && ny < y) {
                    if (map.get(ny).get(nx) == 0) {
                        map.get(ny).set(nx, map.get(inY).get(inX) + 1);
                        q.add(new int[] {ny, nx});
                    }
                }
            }
        }
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;

        boolean isNegative = n == 13;

        if (isNegative) {
            n = System.in.read() & 15;
        }

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return isNegative ? ~n + 1 : n;
    }
}