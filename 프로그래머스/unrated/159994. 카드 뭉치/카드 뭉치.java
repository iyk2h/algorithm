class Solution {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";

        int i = 0;
        int j = 0;
        int count = 0;
        for (String str : goal) {
            if (i < cards1.length && str.equals(cards1[i])) {
                count++;
                i++;
            } else if (j < cards2.length && str.equals(cards2[j])) {
                count++;
                j++;
            } else {
                break;
            }
        }
        if (count == goal.length) {
            answer = "Yes";
        }

        return answer;
    }
}