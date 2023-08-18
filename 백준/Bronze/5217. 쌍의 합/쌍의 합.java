import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			String S = "Pairs for " + n + ": ";
			
			for(int j = 1; j <= n / 2; j++) {
				if(j != (n - j)) {
					
					if(j > 1) {
						S += ", ";
					}
					S += j + " " + (n - j);
				}
			}
			System.out.println(S);
		}
	}

}