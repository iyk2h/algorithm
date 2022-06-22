import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static String[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());

        arr = new String[n][n];
        star(0, 0, n);
        for (String[] strings : arr) {
            for (String string : strings) {
                if(string == null) {
                    bw.write(" ");
                }
                else
                    bw.write(string + "");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void star(int x, int y, int n) {
        if (n == 1) {
            arr[x][y] = "*";
            return;
        }
        int size = n / 3;
        int count = 0;
        for (int i = x; i < x + n; i+=size) {
            for (int j = y; j < y + n; j+=size) {
                count++;
                if(count != 5) {
                    star(i,j,size);
                }
            }
        }
    }
}
