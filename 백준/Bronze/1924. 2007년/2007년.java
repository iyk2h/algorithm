import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String input = bf.readLine();
        String[] md = input.split(" ");

//      기준 1.1 월
//      날자를 입력받으면 1.1일 로부터 카운트
        List<Integer> thirtyOne = List.of(1, 3, 5, 7, 8, 10, 12);
        List<Integer> thirty = List.of(4, 6, 9, 11);
        List<Integer> twentyEight = List.of(2);
        List<String > dayList = List.of("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT");

        int month = Integer.parseInt(md[0]);
        int day = Integer.parseInt(md[1]);

        int sumDay = 0;

        for (int i = 1; i < month; i++) {
            if (thirtyOne.contains(i)) {
                sumDay += 31;
            }
            if (thirty.contains(i)) {
                sumDay += 30;
            }
            if (twentyEight.contains(i)) {
                sumDay += 28;
            }
        }

        sumDay += day;

        System.out.println(dayList.get(sumDay % 7));
    }
}
