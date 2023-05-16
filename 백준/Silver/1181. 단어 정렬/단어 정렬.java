import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static String[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());

        int idx = 0;

        Set<String> boardSet = new HashSet<>();
        String str;
        while ((str = br.readLine()) != null) {
            boardSet.add(str);
        }

        Iterator<String> it = boardSet.iterator();

        board = new String[boardSet.size()];

        while (it.hasNext()) {
            board[idx++] = it.next();
        }

        Arrays.sort(board, (e1, e2) -> {
            if (e1.length() < e2.length()) {
                return -1;
            } else if (e1.length() == e2.length()) {
                return e1.compareTo(e2);
            }
            return 1;
        });

        StringBuffer sb = new StringBuffer();
        for (String tmp : board) {
            sb.append(tmp).append("\n");
        }
        System.out.println(sb);
    }
}