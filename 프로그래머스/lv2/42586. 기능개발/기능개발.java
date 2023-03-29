import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();

        int time = 0;
        int idx = -1;

        for(int i = 0; i < progresses.length; i++){
            int p = progresses[i];
            int s = speeds[i];
            int nTime = (int) Math.ceil((100 - p) / (double)s);

            if(nTime > time){
                list.add(1);
                time = nTime;
                idx++;
            }else{
                list.set(idx, list.get(idx)+1);
            }
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}