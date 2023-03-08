import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        return Stream.of(s.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
    }
}