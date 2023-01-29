import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] ar) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        StringTokenizer st;
        for (int i = 0; i < N; i++) {

            String input = br.readLine();
            ArrayList<String> arrayList = new ArrayList<>();

            for (int j = 0; j < input.length(); j++) {
                switch (String.valueOf(input.charAt(j))) {
                    case "(":
                        arrayList.add("(");
                        break;
                    case ")":
                        if (arrayList.isEmpty()) {
                            arrayList.add(")");
                            j = input.length();
                            break;
                        }
                        arrayList.remove(arrayList.size()-1);
                        break;
                }
            }

            if (arrayList.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

}
