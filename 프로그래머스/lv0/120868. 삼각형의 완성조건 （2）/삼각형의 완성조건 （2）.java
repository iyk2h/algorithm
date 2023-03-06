import java.util.*;

class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
            
        return sides[0] + sides[0] - 1;
    }
}