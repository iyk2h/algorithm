import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int solution(int num, int k) {
        List<Integer> list = Arrays.stream(String.valueOf(num).split(""))
                .map(Integer::parseInt).collect(Collectors.toList());
        
        return list.indexOf(k) != -1 ? list.indexOf(k) + 1 : -1;
    }
}