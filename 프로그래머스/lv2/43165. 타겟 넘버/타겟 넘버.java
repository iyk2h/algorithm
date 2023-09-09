class Solution {
	int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }
    
    
    private void dfs(int[] numbers, int idx, int target, int sum){
        if (numbers.length == idx){
            if (target == sum) {
                answer++;
            }
        }else {
            dfs(numbers, idx + 1, target, sum + numbers[idx]);
            dfs(numbers, idx + 1, target, sum - numbers[idx]);
        }
    }
}