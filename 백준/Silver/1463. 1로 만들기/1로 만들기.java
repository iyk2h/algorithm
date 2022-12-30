import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int input = Integer.parseInt(bf.readLine());


        /*입력값을 1로 만들기 위한 횟수의 최솟값
         *
         *i%3 == 0 -> i / 3
         *i%2 == 0 -> i / 2
         *else i -= 1
         *
         * bottom up 방식으로
         * 최소 횟수를 가지고 있는 배열 초기화
         * 초깃값 : arr[0], arr[1] == 0
         * */

        int arr[] = new int[input + 1];

//      초깃값
        arr[0] = arr[1] = 0;

//      2부터 하는 이유는 1은 이미 0으로 초기화되어있기 때문
        for (int i = 2; i <= input; i++) {
//          i가 2,3으로 나누어 떨어지지 않는다면 1을 더하게 된다.
            arr[i] = arr[i - 1] + 1;

//          i가 2, 3으로 나눠어 떨아지는 경우
//          기존 값과 나눈값을 비교한다.
            if (i % 2 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 2] + 1);
            }
            if (i % 3 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 3] + 1);
            }
        }

        System.out.println(arr[input]);
    }
}
