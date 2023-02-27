import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String my_string) {
        return Stream.of(my_string.toLowerCase().split(""))
                .sorted()
                .collect(Collectors.joining(""))
                ;
    }
}