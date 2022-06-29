import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(bf.readLine());


        TreeSet<Integer> list = new TreeSet<>();


        for (int i = 0; i < a; i++) {
            list.add(Integer.parseInt(bf.readLine()));
        }

        for (Integer integer : list) {
            sb.append(integer+"\n");
        }
        System.out.println(sb);

    }
}
