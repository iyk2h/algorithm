import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i=0;i<n;i++) arr[i] = br.readLine();
        Arrays.sort(arr, (o1, o2) -> {
            if(o1.length() == o2.length()){
                int a = getSum(o1);
                int b = getSum(o2);
                if(a == b){            
                    return o1.compareTo(o2);
                }
                else {
                    return a - b;
                }
            }else {
                return o1.length() - o2.length();
            }
        });
        for (String s : arr) System.out.println(s);
    }
    public static int getSum(String s){
        int a=0;
        s = s.replaceAll("[^0-9]","");
        for(char c : s.toCharArray()) a+=Character.getNumericValue(c);
        return a;
    }
}