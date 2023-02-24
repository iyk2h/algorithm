import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        return (int) IntStream.rangeClosed(1,n).filter(v -> n % v == 0).count();
    }
}