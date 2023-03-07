class Solution {
    public int solution(int[][] board) {
        int answer = 0;

        boolean[][] arr = new boolean[board.length][board[0].length];

        int[] x = {0, 0, 1, -1, -1, 1, -1, 1};
        int[] y = {-1, 1, 0, 0, -1, 1, 1, -1};


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    arr[i][j] = true;

                    for (int k = 0; k < x.length; k++) {
                        int ni = i + x[k];
                        int nj = j + y[k];

                        if (ni < 0 || nj < 0 || ni >= board.length || nj >= board[0].length){
                        }else {
                            arr[ni][nj] = true;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((!arr[i][j])) {
                    answer++;
                }
            }
        }

        return answer;
    }
}