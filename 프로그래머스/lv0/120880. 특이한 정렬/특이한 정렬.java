import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        // 정수 리스트를 저장할 어레이리스트 생성
        List<Integer> numList = new ArrayList<>();

        // numList 추가
        for (int num : numlist) {
            numList.add(num);
        }

        // numList 정렬
        Collections.sort(numList);

        // numList 정렬 기준 변경 : n과의 차이의 절대값으로 기준
        // 차이가 큰 순으로 오름차순 ->  문제에서 거리가 같은 경우 큰수가 앞으로 와야하는 조건 때문 앞에 '-' 넣어줌
        // 뒤에서 역순으로 정렬할 에정
        numList.sort(Comparator.comparingInt(s -> -(Math.abs(s - n))));

        // 역순으로 정렬
        Collections.reverse(numList);

        // 정렬된 numList 어레이리스트를 int 배열로 변환하여 반환
        return numList.stream().mapToInt(i -> i).toArray();
    }
}