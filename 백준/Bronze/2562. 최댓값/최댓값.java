import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int arr[] = new int[9];
        int i = 1;
        int mx = 0;
        int mi = 0;
        while (i < 10 ){
            arr[i-1] = Integer.parseInt(bf.readLine());
            if (arr[i-1] > mx) {
                mx = arr[i-1];
                mi = i;
            }
            i++;
        }
        System.out.println(mx+"\n"+mi);
    }
}