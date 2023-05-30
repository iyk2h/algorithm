import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int START_TYPE = 1;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int lineCount = Integer.parseInt(br.readLine());
        List<Spot> spots = new ArrayList<>();
        for (int i = 0; i < lineCount; ++i) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            spots.add(new Spot(start, 1));
            spots.add(new Spot(end, 0));
        }
        Collections.sort(spots);

        int answer = 0;
        int conflictCount = 0;
        for (Spot spot : spots) {
            if (spot.type == START_TYPE) {
                conflictCount++;
                answer = Math.max(answer, conflictCount);
            } else {
                conflictCount--;
            }
        }

        System.out.println(answer);
    }
}

class Spot implements Comparable<Spot> {
    int point;
    int type;

    public Spot(final int point, final int type) {
        this.point = point;
        this.type = type;
    }

    @Override
    public int compareTo(final Spot o) {
        if (point == o.point) {
            return Integer.compare(type, o.type);
        }
        return Integer.compare(point, o.point);
    }
}