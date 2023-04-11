import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        Arrays.sort(arr, (e1, e2) ->{
            return Integer.parseInt(e1) - Integer.parseInt(e2); 
        });

        System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
    }
}