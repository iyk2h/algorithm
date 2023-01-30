import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] ar) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int index = 1;

        SegmentTree segmentTree = new SegmentTree(N);
        segmentTree.init(1, N, 1);

        sb.append("<");

        for (int i = 0; i < N; i++) {
            int size = N - i;
            index += (K - 1);

            if (index % size == 0) {
                index = size;
            } else if (index > size) {
                index %= size;
            }

            int delIndex = segmentTree.query(1, N, 1, index);

            segmentTree.update(1, N, 1, delIndex);

            if (i == N - 1) {
                sb.append(delIndex);
            } else {
                sb.append(delIndex).append(", ");
            }
        }

        sb.append(">");

        System.out.println(sb);

    }

}

class SegmentTree {

    long tree[];
    int treeSize;

    public SegmentTree(int arrSize) {
        int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));

        treeSize = (int) Math.pow(2, h + 1);
        tree = new long[treeSize];
    }

    public long init(int start, int end, int treeIndex) {
        if (start == end) {
            return tree[treeIndex] = 1;
        }

        return tree[treeIndex] = init(start, (start + end) / 2, treeIndex * 2)
                + init((start + end) / 2 + 1, end, treeIndex * 2 + 1);
    }

    public int update(int start, int end, int treeIndex, int delIndex) {
        tree[treeIndex]--;
        if (start == end) {
            return 0;
        } else {
            int mid = (start + end) / 2;
            if (delIndex <= mid) {
                return update(start, mid, treeIndex * 2, delIndex);
            } else {
                return update(mid + 1, end, treeIndex * 2 + 1, delIndex);
            }
        }
    }

    // 다음 순서에 해당하는 번호 받아오기
    public int query(int start, int end, int treeIndex, int order) {
        if (start == end) {
            return start;
        }
        int mid = (start + end) / 2;

        if (order <= tree[2 * treeIndex]) {
            return query(start, mid, treeIndex * 2, order);
        } else {
            return query(mid + 1, end, treeIndex * 2 + 1, (int) (order - tree[treeIndex * 2]));
        }
    }
}
