class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++){
            answer[i] = "";
            
            
            
            String line1 = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr1[i])));
            if(line1.equals("0")){
                line1 = line1.repeat(n);
            }
            String line2 = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr2[i])));
            if(line2.equals("0")){
                line2 = line2.repeat(n);
            }
            
            for(int j = 0; j < n; j++){
                if(line1.charAt(j) == '1' || line2.charAt(j) == '1'){
                    answer[i] += "#";
                }else{
                    answer[i] += " ";
                }
            }
            
        }
        
        return answer;
    }
}