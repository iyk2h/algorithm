
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'c') {
                if (i < str.length() - 1) {
                    if (str.charAt(i + 1) == '-') {
                        count--;
                    } else if (str.charAt(i + 1) == '=') {
                        count--;
                    }
                }
            }
            if (str.charAt(i) == 'd') {
                if (i < str.length() - 1) {
                    if (str.charAt(i + 1) == '-') {
                        count--;
                    }
                }
                if (i < str.length() - 2) {
                    if (str.charAt(i + 1) == 'z') {
                        if (str.charAt(i + 2) == '=') {
                            count -= 1;
                        }
                    }
                }
            }

            if (str.charAt(i) == 'l' | str.charAt(i) == 'n') {
                if (i < str.length() - 1) {
                    if (str.charAt(i + 1) == 'j') {
                        count--;
                    }
                }
            }

            if (str.charAt(i) == 's' | str.charAt(i) == 'z') {
                if (i < str.length() - 1) {
                    if (str.charAt(i + 1) == '=') {
                        count--;
                    }
                }
            }

            count++;
            }

            System.out.println(count);
    }
}
