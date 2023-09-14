import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] a = new int[]{1,2,3,4,5}; // 5
        int[] b = new int[]{2,1,2,3,2,4,2,5}; // 8
        int[] c = new int[]{3,3,1,1,2,2,4,4,5,5}; // 10
        
        int[] abc = new int[]{0,0,0};
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == a[i % 5]) {
                abc[0]++;
            }
            if (answers[i] == b[i % 8]) {
                abc[1]++;
            }
            if (answers[i] == c[i % 10]) {
                abc[2]++;
            }
        }
        
        int max = 0;
        for (int i : abc) {
            if (max < i) {
                max = i;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            if (abc[i - 1] == max) {
                list.add(i);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}