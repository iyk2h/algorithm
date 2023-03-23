import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        int[] arr = new int[241];

        for(int i : people){
            arr[i] += 1;
        }

        Arrays.sort(people);

        for(int i : people){
            if (limit - i < i && arr[i] > 0){
                arr[i]--;
                answer++;
            }
            for(int j = limit - i; j >= i; j--){
                if(arr[j] > 0){
                    answer++;
                    arr[i]--;
                    arr[j]--;
                    break;
                }
            }
        }

        return answer;
    }
}