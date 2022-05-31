import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bf.readLine());
        String str[] = new String[input];
        int i = 0;
        while (i<input) {
            int sum = 0;
            int count = 0;
            str[i] = bf.readLine();

            for(int o =0 ; o<str[i].length() ; o++){
                char c = str[i].charAt(o);
                if(c == 'O'){
                    count++;
                    sum += count;
                }
                else {
                    count = 0;
                }
            }
            System.out.println(sum);
            i++;
        }
    }
}