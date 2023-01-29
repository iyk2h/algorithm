import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] ar) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String buf = "";

        while ((buf = br.readLine()) != null) {
            System.out.println(buf.length());
        }
    }
}
