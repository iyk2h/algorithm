import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
       
        int w = Integer.MIN_VALUE;
        int h = Integer.MIN_VALUE;
        
        for(int [] arr : sizes){
            Arrays.sort(arr);
            if(arr[0] > w){
                w = arr[0];
            }
            if(arr[1] > h){
                h = arr[1];
            }
        }
        
        System.out.println(w);
        System.out.println(h);
        
        return w * h;
    }
}