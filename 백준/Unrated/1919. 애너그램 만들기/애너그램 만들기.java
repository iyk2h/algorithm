import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] ar) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int[] alpha = new int[26];

//        int n = Integer.parseInt(br.readLine());
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        for (char c : a) {
            alpha[c - 'a']++;
        }
        for (char c : b) {
            int i = c - 'a';
            alpha[i]--;
        }
        for (int i = 0; i < 26; i++) {
            answer += Math.abs(alpha[i]);
        }
        System.out.println(answer);
    }
}