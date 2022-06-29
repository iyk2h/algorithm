import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(bf.readLine());


//        TreeSet<Integer> list = new TreeSet<>();

        int arr[] = new int[a];

        for (int i = 0; i < a; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(arr);


        for (int i = 0; i < a; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);

    }
}
