import java.util.Stack;

class Solution {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack[] stacks = new Stack[board[0].length];
        Stack<Integer> box = new Stack<>();

        for (int j = board.length - 1; j >= 0; j--) {
            stacks[j] = new Stack();
            for (int i = board[0].length - 1; i >= 0; i--) {
                if (board[i][j] != 0) {
                    stacks[j].add(board[i][j]);
                }
            }
        }

        for (int i : moves) {
            if (!stacks[i - 1].isEmpty()) {
                // 비어있지않고, 맨 위 값이 같은 경우
                if (!box.isEmpty() && box.peek() == stacks[i - 1].peek()) {
                    box.pop();
                    stacks[i - 1].pop();
                    answer += 2;
                }
                // 쌓기
                else {
                    box.add((Integer) stacks[i - 1].pop());
                }
            }
        }

        return answer;
    }
}