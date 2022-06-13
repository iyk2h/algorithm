import java.io.*;
import java.math.BigInteger;
import java.security.cert.Extension;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        BigInteger a = new BigInteger((st.nextToken()));
        BigInteger b = new BigInteger(st.nextToken());
        a = a.add(b);
        System.out.println(a.toString());
    }
}