import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();

        for(int i = 0; i < N.length(); i++) {
            String a = Integer.toBinaryString(N.charAt(i)-'0');
            if(a.length()==2 && i!=0) a="0"+a;
            else if(a.length()==1 && i!=0) a="00"+a;

            System.out.print(a);
        }
    }
}
