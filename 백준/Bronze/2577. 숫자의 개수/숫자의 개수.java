import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        int a = Integer.parseInt(bf.readLine());
        int b = Integer.parseInt(bf.readLine());
        int c = Integer.parseInt(bf.readLine());

        int arr[] = new int[10];

        int merge = a*b*c;

        while (merge > 0) {
            int sw = merge%10;
            merge = merge/10;

            for( int j = 0; j<10; j++){
                if (sw == j){
                    arr[j]=arr[j]+1;
                }
            }
        }
        for( int p : arr) {
            System.out.println(p);
        }
    }
}

