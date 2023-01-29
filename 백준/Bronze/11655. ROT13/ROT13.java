import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] ar) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String buf = "";

        while ((buf = br.readLine()) != null) {
            int[] arr = new int[4];
            for (int i = 0; i < buf.length(); i++) {
                char c = buf.charAt(i);

                int charValue = 0;
                if (c <= 'z' && c >= 'a') {
                    if (c >= 'n') {
                        charValue = c - 13;
                    } else {
                        charValue = c + 13;
                    }
                    System.out.print((char) (charValue));
                    continue;
                } else if (c <= 'Z' && c >= 'A') {
                    if (c >= 'N') {
                        charValue = c - 13;
                    } else {
                        charValue = c + 13;
                    }
                    System.out.print((char) charValue);
                    continue;
                }
                System.out.print(c);
            }
        }
    }
}
