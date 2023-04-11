import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<Node> mydeque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!mydeque.isEmpty() && mydeque.getLast().value > now) {
                mydeque.removeLast();
            }

            mydeque.addLast(new Node(i, now));

            while (mydeque.getFirst().index <= i - L) {
                mydeque.removeFirst();
            }

            bw.write(mydeque.getFirst().value + " ");
        }
        bw.flush();
    }
}

class Node {

    public int index, value;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}