package boj.src.main.no14681;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int Quafrant = 0;
        int  x = Integer.parseInt(bf.readLine());
        int y = Integer.parseInt(bf.readLine());

        if (x>0) {
            if (y>0) {
                Quafrant = 1;
            }
            else {
                Quafrant = 4;
            }
        }
        else {
            if (y>0) {
                Quafrant = 2;
            }
            else {
                Quafrant = 3;
            }
        }
        System.out.println(Quafrant);
    }
}
