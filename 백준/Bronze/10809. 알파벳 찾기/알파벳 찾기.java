import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {



        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();

        int arr[] = new int[26];

        for(int i = 97 ; i<=122 ; i++) {
            arr[i-97] = -1;
            for(int a =0 ; a < input.length(); a++ ) {
                if (i == input.charAt(a) & arr[i-97] == -1) {
                    arr[i-97] = a;
                }
                else if (arr[i-97] == -1) {
                    arr[i-97] = -1;
                }
            }
        }
        for(int a : arr) {
            System.out.print(a+" ");
        }
    }
}