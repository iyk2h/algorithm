import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        Integer score;
        while ((str = bf.readLine()) != null){
             score = Integer.parseInt(str);

            if (score <= 100 & score >= 90) {
                System.out.println("A");
            }
            else if (score < 90 & score >= 80) {
                    System.out.println("B");
            }
            else if (score < 80 & score >= 70) {
                System.out.println("C");
            }
            else if (score < 70 & score >= 60) {
                System.out.println("D");
            }
            else
                System.out.println("F");
        }
    }
}