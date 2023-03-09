import java.util.Arrays;

class Solution {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {

            int[] nArr = Arrays.stream(array, commands[i][0] - 1, commands[i][1]).toArray();

            Arrays.sort(nArr);

            int value = nArr[commands[i][2] - 1];
            answer[i] = value;
        }

        return answer;
    }
}