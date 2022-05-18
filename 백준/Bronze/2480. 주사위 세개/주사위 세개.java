
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int result, sec = 0;
        // 입력값 3개가 같은지 -> 10000 + 같은 값 * 1000
        // 입력값 2개가 같은지 -> 1000+같은 값 * 100
        // 같은게 없으면 가장 큰 값*100

        // 입력 값 같은 개수 카운트, 같은 값 출력

        if(a==b & b==c & a == c){
            result = 10000 + a * 1000;
        }
        else if (a == b | b == c | a == c) {
            if (a == b | a == c){
                sec = a;
            }
            else {
                sec = b;
            }
            result = 1000 + sec *100;
        }
        else {
            result = Math.max(a,Math.max(b,c)) * 100;
        }
        System.out.println(result);
    }
}
