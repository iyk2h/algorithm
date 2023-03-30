class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String str = "";
        while(n > 0){
            str = n % k + str;
            n /= k;
        }
        
        str = str.replaceAll("0+", "-");
        
        for(String data : str.split("-")){
            long l = Long.parseLong(data);
            if(isPrime(l)){
                answer++;
            }
        }      

        return answer;
    }
    
    public boolean isPrime(long a){
        if(a<2) return false;
        
        for(int i=2;i<=Math.sqrt(a);i++){
            if(a%i==0){
                return false;
            }
        }
        return true;
    }
}