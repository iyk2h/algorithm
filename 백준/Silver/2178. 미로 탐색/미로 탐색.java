import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static ArrayList<ArrayList<Integer>> map;
    static ArrayList<ArrayList<Boolean>> visited;
    static int x;
    static int y;
    static int d = 0;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        y = read();
        x = read();

        map = new ArrayList<>();
        visited = new ArrayList<>();

        for (int i = 0; i < y; i++) {
            map.add(new ArrayList<>());
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                map.get(i).add(str.charAt(j) - '0');
            }
        }

        q.add(new int[]{0, 0});
        bfs();

    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int inY = t[0];
            int inX = t[1];

            if (inY == y - 1 && inX == x - 1) {
                System.out.println(map.get(inY).get(inX));
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = inY + dy[i];
                int nx = inX + dx[i];

                if (nx >= 0 && ny >= 0 && nx < x && ny < y) {
                    if (map.get(ny).get(nx) == 1) {
                        map.get(ny).set(nx, map.get(inY).get(inX) + 1);
                        q.add(new int[]{ny, nx});
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

    static int readChar() throws Exception {
        return System.in.read() & 15;
    }
}