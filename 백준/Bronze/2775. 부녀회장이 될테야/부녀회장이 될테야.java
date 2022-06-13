import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int input = Integer.parseInt(bf.readLine());

        while (input > 0) {
            int k = Integer.parseInt(bf.readLine());
            int n = Integer.parseInt(bf.readLine());
            int arr[][] = new int[k+1][n+1];
            for (int a = 0; a <= k; a++) {
                for (int b = 1; b <= n; b++) {
                    if(a == 0) {
                        arr[a][b] = b;
                    }
                    else if (a > 0) {
                        for (int c = 0; c <= b; c++ ){
                            arr[a][b] += arr[a-1][c];
                        }
                    }
                }
            }
            System.out.println(arr[k][n]);
            input--;
        }
    }
}