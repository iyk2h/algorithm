import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] ar) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> deque = new ArrayList<>();

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push_front":
                    deque.add(0, Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.get(0));
                        deque.remove(0);
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.get(deque.size() - 1));
                        deque.remove(deque.size() - 1);
                    }
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.get(0));
                    }
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.get(deque.size() - 1));
                    }
                    break;
            }

        }
    }
}
