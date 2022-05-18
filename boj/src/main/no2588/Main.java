package boj.src.no2588;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer A = scanner.nextInt();
        String B = scanner.next();

        use_math(A,Integer.parseInt(B)); // 이 부분만 문자열이 아닌 integer 사용
        use_charAt(A,B);
        use_toCharArray(A,B);
    }

    private static void use_math(Integer A, Integer B) {
        int tmp = B;
        int b = 0;
        while( B > 0 ) {
            b = B % 10; // B값의 1의 자리수 추출
            B /= 10; // B값의 1의 자리수 제외한 값
            System.out.println(A * b);
        }
        System.out.println(A * tmp);
    }

    private static void use_charAt(Integer A, String B) {
        for( int i = B.length()-1 ; i>=0 ; i--) {
            System.out.println(A* (B.charAt(i)-'0')); // B의 자릿수 1부터 추출
        }
        System.out.println(A * Integer.parseInt(B));

    }

    private static void use_toCharArray(Integer A, String B) {
        char[] b = B.toCharArray(); // String B 값을 b[] 배열로

        for( int i = B.length()-1 ; i>=0 ; i--) {
            System.out.println(A* (b[i]-'0')); // b배열 자릿수 1부터 추출
        }
        System.out.println(A * Integer.parseInt(B));
    }
}
