class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        int min = Math.min(a,b);
        int max = Math.max(a,b);
        
        while(true){
            if(min % 2 == 1 && min + 1 == max){
                break;
            }
            answer++;
            min = (min + 1) / 2;
            max = (max + 1) / 2;
        }
        

        return answer;
    }
}