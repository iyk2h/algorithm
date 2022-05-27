import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int a = 0;
        Set s = new HashSet();
        int arr[] = new int[10];
        for(int i : arr) {
            s.add(Integer.parseInt(bf.readLine())%42);
            a++;
        }
        System.out.println(s.size());
    }
}