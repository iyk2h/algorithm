import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int in = Integer.parseInt(bf.readLine());
        int answer = 0;

        if(in%5==0) {
            answer = in/5;
        }
        else if ((in%5)%3 ==0 ) {
            answer = in/5 + (in%5)/3;
        }
        else if (in > 5 & ( (in%5) == 1 | (in%5) == 4 ) ){
            answer = in/5 - 1 + ((in%5)+5)/3;
        }
        else if ( in > 15 & ( (in%5) == 2 )){
            answer = in/5 - 2 + ((in%5)+10)/3;
        }
        else if ( in%3 == 0) {
            answer = in/3;
        }
        else
            answer = -1;
        System.out.println(answer);
    }
}