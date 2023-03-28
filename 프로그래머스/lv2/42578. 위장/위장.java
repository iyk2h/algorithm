import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        // 종류별 옷 카운트
        for(int i =0; i<clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1],0)+1);
        }
        
        Iterator<Integer> it = map.values().iterator();
        // 조합의 경우의 수
        while(it.hasNext()) {
            // + 1 는 하나만 선택 가능 하기 때문
            answer *= it.next().intValue()+1;
        }
        // 아무것도 입지 않는 수는 없다.
        return answer-1;
    }
}