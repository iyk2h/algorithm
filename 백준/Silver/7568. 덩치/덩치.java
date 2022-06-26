import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int n = Integer.parseInt(bf.readLine());

        int arr[][] = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < arr.length; i++) {
            int r = 1;
            for (int i1 = 0; i1 < arr.length; i1++) {
                if(i == i1){
                    continue;
                }
                if(arr[i][0] < arr[i1][0] & arr[i][1] < arr[i1][1]) {
                    r++;
                }
            }
            System.out.print(r+" ");
        }
    }
}
