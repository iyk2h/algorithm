import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringTokenizer list = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = 0;

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(Integer.valueOf(list.nextToken()));
        }

        for (int i = 0; i < arr.size()-2; i++) {
            for (int i1 = i+1; i1 < arr.size()-1; i1++) {
                for (int i2 = i1+1; i2 < arr.size(); i2++) {
                    int sum = arr.get(i)+arr.get(i1)+arr.get(i2);

                    if(sum>m) {
                        continue;
                    }
                    else if (sum == m ) {
                        System.out.println(sum);
                        return;
                    }
                    else if (sum < m) {
                        if (max<sum) {
                            max = sum;
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}
