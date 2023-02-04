import java.util.ArrayList;

public class Main {

    static ArrayList<ArrayList<Integer>> map;
    static ArrayList<ArrayList<Boolean>> visited;
    static int x;
    static int y;
    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        while (true) {
            x = read();
            y = read();

            if (x == 0 && y == 0) {
                System.out.println(sb);
                return;
            }

            map = new ArrayList<>();
            visited = new ArrayList<>();

            for (int i = 0; i < y; i++) {
                map.add(new ArrayList<Integer>());
                visited.add(new ArrayList<Boolean>());
                for (int j = 0; j < x; j++) {
                    map.get(i).add(read());
                    visited.get(i).add(false);
                }
            }

            int count = 0;

            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (map.get(i).get(j) == 1 && !visited.get(i).get(j)) {
                        count++;
                        dfs(i, j);
                    }
                }
            }
            sb.append(count).append("\n");
        }
    }

    private static void dfs(int inY, int inX) {
        visited.get(inY).set(inX, true);

        for (int i = 0; i < 8; i++) {
            int ny = inY + dy[i];
            int nx = inX + dx[i];

            if (nx >= 0 && ny >= 0 && nx < x && ny < y) {
                if (map.get(ny).get(nx) == 1 && !visited.get(ny).get(nx)) {
                    dfs(ny, nx);
                }
            }
        }
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}