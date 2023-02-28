import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        ArrayList<ArrayList<Integer>> answerList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int size = 0;
                if (arr[i][j] == '*') {
                    for (int k = 1; ; k++) {
                        if (i - k >= 0 && j-k >=0 && i + k < N && j + k < M) {
                            if (arr[i - k][j] == '*' && arr[i + k][j] == '*'
                                    && arr[i][j - k] == '*' && arr[i][j + k] == '*') {
                                size = k;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }


                if (size > 0) {
                    answerList.add(new ArrayList<>(Arrays.asList(i+1, j+1, size)));
                    visited[i][j] = true;
                    for (int k = size; k > 0; k--) {

//                        answerList.get(answerList.size() - 1).add(i + 1);
//                        answerList.get(answerList.size() - 1).add(j + 1);
//                        answerList.get(answerList.size() - 1).add(k);

                        visited[i + k][j] = true;
                        visited[i - k][j] = true;
                        visited[i][j + k] = true;
                        visited[i][j - k] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == '*' && !visited[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }


        sb.append(answerList.size()).append("\n");

        for (ArrayList<Integer> inList : answerList) {
            sb.append(inList.get(0)).append(" ").append(inList.get(1)).append(" ")
                    .append(inList.get(2)).append("\n");
        }

        System.out.println(sb);
    }
}