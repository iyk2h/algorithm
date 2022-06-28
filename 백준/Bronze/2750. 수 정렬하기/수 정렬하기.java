
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int a = Integer.parseInt(bf.readLine());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < a; i++) {
            list.add(i, Integer.parseInt(bf.readLine()));
        }

        Collections.sort(list);

        for (Integer integer : list) {
            System.out.println(integer);
        }

    }
}
