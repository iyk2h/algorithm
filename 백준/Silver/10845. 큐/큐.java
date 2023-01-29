import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] ar) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> queue = new ArrayList<>();

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    queue.add(value);
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(queue.get(0));
                        queue.remove(0);
                    }
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(queue.get(0));
                    }
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(queue.get(queue.size() - 1));
                    }
                    break;
            }

        }
    }
}
