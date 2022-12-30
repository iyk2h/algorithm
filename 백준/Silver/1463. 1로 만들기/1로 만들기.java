

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(bf.readLine());

        /*
        input -> 1 까지 연산의 최솟값

        3가지 연산 가능
        input 이 3으로 나누어 떨어지면, 3으로 나눈다.
        input 이 2로 나누어 떨어지면, 2로 나눈다.
        아니면 1을 뺀다.

        그럼 조건식이 2개 나온다.
        input 이 2로 나누어 떨어지면, 2로 나눈값 vs 1을 뺀 값
        input 이 3로 나누어 떨어지면, 3로 나눈값 vs 1을 뺀 값

        초깃값
        dp[0] = dp[1] = 0
        */

        int[] dp = new int[input + 1];

        dp[0] = dp[1] = 0;

        // 2부터 하는 이유는 bottom up, 1은 이미 초기화 되어있음
        for (int i = 2; i <= input; i++) {
            // 1을 빼는 경우 바로 직전의 위치 누적 값 + 1
            dp[i] = dp[i - 1] + 1;

            // 2로 나누어지는 경우 현재 누적 횟수 vs 2로 나눈 값의 누적 횟수 비교
            if (i % 2 == 0) {
                // 2로 나누어 떨어지는 경우 = i / 2위치 누적 값 + 1
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                // 3로 나누어 떨어지는 경우 = i / 3위치 누적 값 + 1
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        System.out.println(dp[input]);
    }
}
