class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];

        int idx = 0;
        
        for (int[] arr : score) {
            int sum = arr[0] + arr[1];
            int count = 0;
            for (int[] arr2 : score) {
                int sum2 = arr2[0] + arr2[1];
                if (sum < sum2) {
                    count++;
                }
            }
            answer[idx] = count + 1;
            idx++;
        }

        return answer;
    }
}