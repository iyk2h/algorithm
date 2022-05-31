import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int input = Integer.parseInt(bf.readLine());
        int i = 0;
        while (i < input) {
            int count = 0;

            st = new StringTokenizer(bf.readLine(), " ");

            int num = Integer.parseInt(st.nextToken());
            int arr[] = new int[num];

            for (int n = 0; n < num; n++) {
                arr[n] = Integer.parseInt(st.nextToken());
            }

            for (int n = 0; n < num; n++) {
                if((double)arr[n] > (Arrays.stream(arr).average().getAsDouble())){
                    count++;
                }
            }
            double result = (double) count / arr.length * 100;
            System.out.printf("%.3f",result);
            System.out.println("%");
            i++;
        }
    }
}