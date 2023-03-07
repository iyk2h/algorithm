import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    public long solution(long n) {
        List<Integer> list = String.valueOf(n).chars().boxed().map(e -> e - '0')
                .sorted(Collections.reverseOrder()).collect(Collectors.toList());

        String str = list.stream().map(String::valueOf).collect(Collectors.joining());

        return Long.parseLong(str);
    }
}