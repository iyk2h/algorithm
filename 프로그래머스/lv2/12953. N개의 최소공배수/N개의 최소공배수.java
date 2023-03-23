class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        for(int i = 0; i < arr.length - 1; i++){
            answer = arr[i] * arr[i + 1] / lcm(arr[i], arr[i +1]);
            
            arr[i + 1] = answer;
        }
        
        return answer;
    }
    
    public int lcm(int a, int b){
        
        if(a < b){
            int i = a;
            a = b;
            b = i;
        }
        
        
        while(b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}