import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String a = (st.nextToken());
        String b = (st.nextToken());

        int na = 0;
        int nb = 0;

        for( int i = 2 ; i >= 0 ; i-- ) {
            na += (a.charAt(i)-48) * ((int)Math.pow(10, i));
            nb += (b.charAt(i)-48) * ((int)Math.pow(10, i));
        }
        System.out.println(Math.max(na, nb));
    }
}