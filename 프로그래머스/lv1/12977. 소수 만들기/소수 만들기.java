import java.util.Arrays;

class Solution {

    boolean[] check;
    public int solution(int[] nums) {
        int answer = 0;

        int max = Arrays.stream(nums).sorted().sum();

        check = new boolean[max];
        setCheck(max);

        for (int i = 0; i < nums.length -2; i++) {
            for (int j = i + 1; j < nums.length -1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (check[sum - 1]) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    private void setCheck(int n) {
        check[0] = check[1] = check[2] = true;
        for (int i = 4; i <= n; i++) {
            check[i - 1] = true;
            for (int j = 2; j <= Math.sqrt(i); j++){
                if (i % j == 0) {
                    check[i - 1] = false;
                    break;
                }
            }
        }
    }
}