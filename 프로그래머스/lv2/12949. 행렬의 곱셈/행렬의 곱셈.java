class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int col = arr1.length;
        int row = arr2[0].length;

        int[][] answer = new int[col][row];
        
        for(int c = 0; c < col; c++){
            for(int r = 0; r < row; r++){
                for(int i = 0; i < arr1[0].length; i++){
                    answer[c][r] += arr1[c][i] * arr2[i][r];
                }
            }
        }

        return answer;
    }
}