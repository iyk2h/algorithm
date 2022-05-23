import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int max = -1000000, min = 1000000;
        while (input>0) {
            int tmp = Integer.parseInt(st.nextToken());
            max=Math.max(max,tmp);
            min=Math.min(min, tmp);
            input--;
        }

        System.out.println(min+" "+max);
    }
}
