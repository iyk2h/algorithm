import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int max = 0;
    static int lastNode;

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        tree = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            int s = scan.nextInt();
            while(true) {
                int index = scan.nextInt();
                if(index == -1) break;
                int cost = scan.nextInt();
                tree[s].add(new Node(index, cost));
            }
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        dfs(lastNode, 0);

        System.out.println(max);
    }

    public static void dfs(int x, int len) {
        if(len > max) {
            max = len;
            lastNode = x;
        }
        visited[x] = true;

        for(int i = 0; i < tree[x].size(); i++) {
            Node n = tree[x].get(i);
            if(!visited[n.index]) {
                dfs(n.index, n.cost + len);
                visited[n.index] = true;
            }
        }

    }

    public static class Node {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}
