import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        int str = Integer.parseInt(bf.readLine());
        int count = 0;
        List<Character> cl = new ArrayList<Character>();
        while (str > 0) {
            boolean check[] = new boolean[26]; // 알파벳 26개, 기본 false 로 선언
            String st = bf.readLine();
            for (int i = 0; i < st.length(); i++) {
                if (check[((int) (st.charAt(i)) - 'a')] == false) {
                    check[((int) (st.charAt(i)) - 'a')] = true;
                } else if (check[((int)(st.charAt(i))-'a')] == true){
                    if (i > 0 ) {
                        if ( st.charAt(i - 1) != st.charAt(i) ) {
                            count--;
                            break;
                        }
                    }
                }
            }
            count++;
            str--;
        }
        System.out.println(count);
    }
}
