import java.io.IOException;
import java.util.ArrayList;
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
        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();
        ArrayList<Integer> s = new ArrayList<Integer>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                int size = 0; // 십자가 크기
                if(grid[i][j] == '*') {
                    for(int k=1; ; k++) {
                        if(i-k >= 0 && i+k < N && j-k >=0 && j+k < M) {
                            if(grid[i-k][j] == '*' && grid[i+k][j] == '*' && grid[i][j-k] == '*' && grid[i][j+k] == '*') {
                                size = k;
                            }
                            else break;
                        }
                        else break;
                    }
                }

                if(size > 0) {
                    x.add(i+1);
                    y.add(j+1);
                    s.add(size);
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

        // 격자판 만들 수 없을 때
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(grid[i][j] == '*' && visited[i][j] == false) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }

        // 격자판 만들 수 있을 때
        StringBuilder sb = new StringBuilder();

        int count = 0;

        for(int i=0; i<x.size(); i++) {
            for(int j=s.get(i); j>=1; j--) {
                count++;
                sb.append(x.get(i)+" "+y.get(i)+" "+j).append("\n");
            }
        }
        sc.close();

        System.out.println(count);
        System.out.println(sb);
    }

}