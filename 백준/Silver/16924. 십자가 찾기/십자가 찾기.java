import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] grid = new char[N][M];
        boolean[][] visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String line = sc.next();
            for(int j=0; j<M; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                int size = 0; // cross size
                if(grid[i][j] == '*') {
                    for(int k=1; ; k++) {
                        if(i-k >= 0 && i+k < N && j-k >=0 && j+k < M) {
                            if(grid[i-k][j] == '*' && grid[i+k][j] == '*' && grid[i][j-k] == '*' && grid[i][j+ k] == '*') {
                                size = k;
                            }
                            else break;
                        }
                        else break;
                    }
                }

                if(size > 0) {
                    ArrayList<Integer> cross = new ArrayList<>(Arrays.asList(i+1, j+1, size));
                    arr.add(cross);
                    visited[i][j] = true;
                    for(int k=1; k<=size; k++) {
                        visited[i+k][j] = true;
                        visited[i-k][j] = true;
                        visited[i][j+k] = true;
                        visited[i][j-k] = true;
                    }
                }
            }
        }

        // when grid cannot be created
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(grid[i][j] == '*' && visited[i][j] == false) {
                    System.out.println(-1);
                    System. exit(0);
                }
            }
        }

        // when grid can be created
        StringBuilder sb = new StringBuilder();

        int count = 0;

        for(ArrayList<Integer> cross : arr) {
            int x = cross.get(0);
            int y = cross.get(1);
            int size = cross.get(2);
            for(int j=size; j>=1; j--) {
                count++;
                sb.append(x+" "+y+" "+j).append("\n");
            }
        }
        sc.close();

        System.out.println(count);
        System.out.println(sb);
    }
}
