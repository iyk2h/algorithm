
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int a = Integer.parseInt(bf.readLine());
        List<Integer> la = new ArrayList<>();
        while (a>0){
            st = new StringTokenizer(bf.readLine());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            la.add(b+c);
            a--;
        }
        for(int i : la) {
            bw.write(i+"\n");
        }
        bw.close();
    }
}