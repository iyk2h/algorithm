import java.util.*;

class Solution {
    public int solution(int[] array, int height) {

        int si = 0;
        int li = array.length;

        Arrays.sort(array);

        while(si < li){
            int mid = (si + li ) / 2;

            if(height < array[mid]){
                li = mid;
            }else{
                si = mid + 1;
            }
        }

        return array.length - si;
    }
}