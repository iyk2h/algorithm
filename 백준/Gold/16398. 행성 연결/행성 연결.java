import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    private static int[] parent;
    private static int N;
    private static List<Edge> edgeList = new ArrayList<>();
    private static long answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int weight = sc.nextInt();
                if (weight != 0) { // 연결 가능한 경우
                    edgeList.add(new Edge(i, j, weight));
                }
            }
        }
        Collections.sort(edgeList);
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            if (!isSameParent(edge.start, edge.end)) {
                answer += edge.weight;
                union(edge.start, edge.end);
            }
        }
        System.out.println(answer);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a < b) parent[b] = a;
            else parent[a] = b;
        }
    }

    private static boolean isSameParent(int a, int b) {
        return find(a) == find(b);
    }


    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }
}