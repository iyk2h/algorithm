import java.util.*;

class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        int max = sides[2];
        int tmp = sides[0] + sides[1];
        if(max >= tmp) return 2;
        else return 1;
    }
}