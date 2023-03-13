import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    public int[] solution(int N, int[] stages) {
        int hum = stages.length;

        Arrays.sort(stages);

        Map<Integer, Double> set = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            int finalI = i;
            int tmp = (int) Arrays.stream(stages).filter(e -> (e == finalI)).count();
                                  
            set.put(i, (((double) tmp / hum)));
            
            if( tmp == 0){
                set.put(i, (double) 0);
            }

            hum -= tmp;
        }

        return set.entrySet().stream().sorted(new Comparator<Entry<Integer, Double>>() {
            @Override
            public int compare(Entry<Integer, Double> o1, Entry<Integer, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        }).mapToInt(Entry::getKey).toArray();
    }
}