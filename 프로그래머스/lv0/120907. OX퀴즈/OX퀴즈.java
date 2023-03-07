class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for(int i = 0; i < quiz.length; i++) {
            String[] arr = quiz[i].split(" ");
            
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[2]);
            int c = Integer.parseInt(arr[4]);
            
            for(int j = 1; j < arr.length; j += 2){
                if(arr[j].equals("-")){
                    b *= -1;
                }   
            }
            
            if(a + b == c){
                answer[i] = "O";
            } else {
                answer[i] = "X";
            }
            
        }
        
        return answer;
    }
}