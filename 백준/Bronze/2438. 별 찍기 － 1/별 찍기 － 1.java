import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int input = Integer.parseInt(bf.readLine());
        int i = 1;
        while(i <= input){
            int a = 0;
            while (a < i) {
                System.out.printf("*");
                a++;
            }
            System.out.println("");
            i++;
        }
    }
}