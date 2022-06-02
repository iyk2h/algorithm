import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(bf.readLine());

        int count =0;

        for (int x = 1; x<=input ; x++) {
            String str = String.valueOf(x);

            int a[] = new int[str.length()];
            int interval[] = new int[str.length()];

            if (str.length() <= 2) {
                count++;
            } else if (str.length() == 3)  {
                for (int i = 0; i < str.length(); i++) {
                    a[i] = str.charAt(i);
                }
                for (int i = 0; i < str.length() - 1; i++) {
                    interval[i] = a[i] - a[i + 1];
                    if(x==1000){
                    }
                }
                for (int i = 0; i < str.length() - 2; i++) {
                    if (interval[i] == interval[i + 1]) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
