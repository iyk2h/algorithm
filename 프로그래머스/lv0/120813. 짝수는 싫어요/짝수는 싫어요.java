import java.util.stream.IntStream;
class Solution {
    public int[] solution(int n) {
        return IntStream.rangeClosed(0, n).filter(value -> value % 2 == 1).toArray();
    }
}