import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] ar) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            char[] ca = str.split(" ")[0].toCharArray();
            char[] cb = str.split(" ")[1].toCharArray();

            Arrays.sort(ca);
            Arrays.sort(cb);

            if (ca.length != cb.length) {
                System.out.println("Impossible");
                continue;
            }

            String a = Arrays.toString(ca);
            String b = Arrays.toString(cb);

            if (a.equals(b)) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
//        System.out.println(answer);
    }
}