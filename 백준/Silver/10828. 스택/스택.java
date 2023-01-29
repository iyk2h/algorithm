import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] ar) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arrayList = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String commend = st.nextToken();

            switch (commend) {
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    arrayList.add(value);
                    break;
                case "pop":
                    if (arrayList.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(arrayList.get(arrayList.size() - 1));
                        arrayList.remove((arrayList.size() - 1));
                    }
                    break;
                case "size":
                    System.out.println(arrayList.size());
                    break;
                case "empty":
                    if (arrayList.isEmpty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "top":
                    if (arrayList.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(arrayList.get(arrayList.size() - 1));
                    }
                    break;
            }
        }
    }

}
