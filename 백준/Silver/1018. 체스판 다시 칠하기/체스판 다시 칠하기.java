import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());



        boolean[][] arr = new boolean[x][y];
        int min = 64;

        for (int i = 0; i < x; i++) {
            String row = bf.readLine();
            for (int i1 = 0; i1 < y; i1++) {
                if(row.charAt(i1) == 'W') {
                    arr[i][i1] = true;
                }
                else
                    arr[i][i1] = false;
            }
        }



        for (int i = 0; i < x-7; i++) {
            for (int i1 = 0; i1 < y-7; i1++) {

                boolean check = arr[i][i1];
                int count = 0;

                for(int a = i ; a < i+8 ; a++) {
                    for(int b = i1 ; b < i1+8 ; b++) {
                        if(check != arr[a][b]) {
                            count++;
                        }
                        check = (!check);
                    }
                    check = (!check);
                }

                count = Math.min(count, 64-count);

                min = Math.min(min, count);

            }
        }
        System.out.println(min);
    }
}
