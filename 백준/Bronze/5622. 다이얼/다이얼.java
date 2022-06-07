import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];

        String s = bf.readLine();

        int ch;

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            ch = (int)s.charAt(i) - 65;
            switch (ch) {
                case 0: case 1: case 2:
                    count +=2;
                    break;
                case 3: case 4: case 5:
                    count +=3;
                    break;
                case 6: case 7: case 8:
                    count +=4;
                    break;
                case 9: case 10: case 11:
                    count +=5;
                    break;
                case 12: case 13: case 14:
                    count +=6;
                    break;
                case 15: case 16: case 17: case 18:
                    count +=7;
                    break;
                case 19: case 20: case 21:
                    count +=8;
                    break;
                case 22: case 23: case 24: case 25:
                    count +=9;
                    break;
                default :
                    break;
            }
        }
        System.out.println(count+s.length());
    }
}
