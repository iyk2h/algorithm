import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        long mod = 1_000_000_000;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

//        dp[자릿수][자릿값]
        long[][] dp = new long[n + 1][10];


//        dp[1][1~9]를 1로 초기화 하는 이유는, 0의 자리 값은 없기때문
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

//        두 번째 자릿수부터 n까지 탐색
        for (int i = 2; i <= n; i++) {

//            자릿값 0~9 탐색
            for (int j = 0; j < 10; j++) {

//                자릿값이 0인경우 이전 자릿수의 값은 1만 가능
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % mod;
                }
//                자릿값이 9인경우 이전 자릿수의 값은 8만 가능
                else if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % mod;
                }
//                이전 자릿수의 값은 -1, +1 가능
                else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }


        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[n][i];
        }

        System.out.println(result % mod);
    }
}