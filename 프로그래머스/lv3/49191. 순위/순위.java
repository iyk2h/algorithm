import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        
        int[][] board = new int[n + 1][n + 1];
        
        for (int[] i : results) {
            int a = i[0];
            int b = i[1];
            
            board[a][b] = 1;
            board[b][a] = -1;
        }
        
        for (int k = 0; k <= n; k++) {
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    if (board[i][k] == 1 && board[k][j] == 1) {
                        board[i][j] = 1;
                        board[j][i] = -1;
                    }
                }
            }
        }
        
        int answer = 0;
        
        for (int[] i : board) {
            int c = 0;
            for (int j : i) {
                if (j != 0) {
                    c++;
                }
            }
            if (c == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
}