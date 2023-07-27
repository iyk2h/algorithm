import java.util.ArrayList;
import java.util.stream.Collectors;

class Main {

    private static int N, M, K, C[], T[][];
    private static ArrayList<Integer> X;
    private static final int INF = -1 >>> 2;

    public static void main(String[] args) throws Exception {

        init();
        floydWarshall();
        findCities();

        System.out.println(
            X.stream()
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(" "))
        );

    }

    private static void floydWarshall() {
        for (int v = 1; v <= N; v++)
            for (int s = 1; s <= N; s++)
                for (int e = 1; e <= N; e++)
                    T[s][e] = Math.min(T[s][e], T[s][v] + T[v][e]);
    }

    private static void findCities() {
        int min = INF;
        for (int city = 1; city <= N; city++) {
            int max = getMaxTime(city);
            if (min < max) continue;
            if (min > max) {
                min = max;
                X.clear();
            }
            X.add(city);
        }
    }

    private static int getMaxTime(int city) {
        int result = 0;
        for (int friend = 0; friend < K; friend++)
            result = Math.max(result, round(city, C[friend]));
        return result;
    }

    private static int round(int city, int friend) {
        return friend == city ? T[friend][city] : T[friend][city] + T[city][friend];
    }

    private static void init() throws Exception {
        N = read();
        M = read();
        initTimes();
        initCities();
    }

    private static void initTimes() throws Exception {
        T = new int[N + 1][N + 1];
        setInfinity();
        setRoads();
    }

    private static void setInfinity() {
        for (int i = 1; i <= N; i++) for (int j = 1; j <= N; j++) T[i][j] = INF;
    }

    private static void setRoads() throws Exception {
        for (int i = 0; i < M; i++) {
            int A = read();
            int B = read();
            T[A][B] = Math.min(T[A][B], read());
        }
    }

    private static void initCities() throws Exception {
        X = new ArrayList<Integer>(N);
        K = read();
        C = new int[K];
        for (int i = 0; i < K; i++) C[i] = read();
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}