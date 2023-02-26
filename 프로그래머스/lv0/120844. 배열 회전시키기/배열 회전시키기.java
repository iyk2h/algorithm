class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];

        int f = numbers[0];
        int l = numbers[numbers.length - 1];        
        
        if(direction.equals("left")){
            for(int i = 1 ; i < numbers.length - 1; i++){
                answer[i - 1] = numbers[i];
            }
            answer[numbers.length - 2] = l;
            answer[numbers.length - 1] = f;
        } else{
            answer[0] = l;
            answer[1] = f;
            for(int i = 1 ; i < numbers.length - 1; i++){
                answer[i + 1] = numbers[i];
            }
        }
        
        return answer;
    }
}