import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        list = list.subList(num1, num2 + 1);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}