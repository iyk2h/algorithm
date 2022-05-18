import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");


        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int alarm = 45;

        if (M < 45) {
            H--;
            M = 60 - (alarm - M);
            if (H < 0){
                H = 23;
            }
        }
        else {
            M = M-alarm;
        }
        System.out.println(H + " " + M);
    }
}
