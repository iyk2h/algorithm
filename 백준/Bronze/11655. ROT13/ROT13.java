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

                if (c <= 'z' && c >= 'a') {
                    int index = c - 'a';
                    int afterIndex = index + 13;
                    if (afterIndex >= 26) {
                        System.out.print((char) ('a' + afterIndex - 26));
                    } else {
                        System.out.print((char) (c + 13));
                    }
                    continue;
                } else if (c <= 'Z' && c >= 'A') {
                    int index = c - 'A';
                    int afterIndex = index + 13;
                    if (afterIndex >= 26) {
                        System.out.print((char) ('A' + afterIndex - 26));
                    } else {
                        System.out.print((char) (c + 13));
                    }
                    continue;
                }
                System.out.print(c);
            }
        }
    }
}
