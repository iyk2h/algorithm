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
        int arr[] = new int[input];
        int i = 0;
        st = new StringTokenizer(bf.readLine(), " ");
        while (i<input){
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        i = 0;
        int max = Arrays.stream(arr).max().getAsInt();
        double darr[] = new double[input];
        while (i<input){
            darr[i] = ((double) arr[i]/max)*100;
            i++;
        }
        System.out.println(Arrays.stream(darr).average().getAsDouble());
    }
}