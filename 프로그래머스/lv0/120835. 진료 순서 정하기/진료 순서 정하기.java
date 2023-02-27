class Solution {
    public static int[] solution(int[] emergency) {
        int[] result = new int[emergency.length];
        for (int i = 0; i < emergency.length; i++) {
            int count = 1;
            for (int j = 0; j < emergency.length; j++) {
                if (i != j && emergency[i] < emergency[j]) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }
}