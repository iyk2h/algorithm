import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] ar) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        BigDecimal first = BigDecimal.valueOf(Long.parseLong((st.nextToken() + st.nextToken())));
        BigDecimal second = BigDecimal.valueOf(Long.parseLong(st.nextToken() + st.nextToken()));
        System.out.println(first.add(second));
    }
}
