import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> board = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            int idx = Integer.parseInt(st.nextToken());
            board.put(idx, board.getOrDefault(idx, 0) + 1);
        }

        List<Integer> list = new ArrayList<Integer>(board.keySet());

        StringBuffer sb = new StringBuffer();

        list.sort((o1, o2) -> Integer.compare(board.get(o2), board.get(o1)));

        for (Integer idx : list) {
            for (int i = 0; i < board.get(idx); i++) {
                sb.append(idx).append(" ");
            }
        }

        System.out.println(sb);
    }
}