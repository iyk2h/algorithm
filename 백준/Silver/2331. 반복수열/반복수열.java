import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> D = new ArrayList<>();
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        D.add(A);
        int sum;

        String str = String.valueOf(A);
        while (true) {
            sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum += Math.pow(str.charAt(i) - '0', P);
            }
            if (D.contains(sum)) {
                int index = D.indexOf(sum);
                System.out.println(index);
                D.subList(0, index);
                return;
            }
            D.add(sum);
            str = String.valueOf(sum);
        }
    }
}