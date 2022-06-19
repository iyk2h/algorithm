import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static String u_line = "";
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());

        String start = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
        System.out.println(start);
        recursive_function(n);
    }

    public static String recursive_function(int n) {
        String line = u_line;
        System.out.println(line+"\"재귀함수가 뭔가요?\"");
        if ( n == 0 ) {
            System.out.println(line+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(line+"라고 답변하였지.");
            return "";
        }
        else {
            System.out.println(line+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
            System.out.println(line+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
            System.out.println(line+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
        }
        u_line += "____";
        recursive_function(n-1);
        System.out.println(line+"라고 답변하였지.");
        return "";
    }
}
