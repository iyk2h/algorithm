package boj.src.no9498;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Integer score = Integer.parseInt(bf.readLine());

            if (score >= 90) {
                System.out.println("A");
            }
            else if (score >= 80) {
                    System.out.println("B");
            }
            else if (score >= 70) {
                System.out.println("C");
            }
            else if (score >= 60) {
                System.out.println("D");
            }
            else
                System.out.println("F");
    }
}
