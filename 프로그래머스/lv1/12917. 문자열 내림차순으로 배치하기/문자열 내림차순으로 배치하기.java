import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        Character[] tmpArray = s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        
        Arrays.sort(tmpArray , new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o2.compareTo(o1);
            }
        });

        return Arrays.stream(tmpArray).map(String::valueOf).collect(Collectors.joining());
    }
}