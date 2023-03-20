class Solution {

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        for (int j = 0; j < targets.length; j++) {
            String str = targets[j];

            for (int i = 0; i < str.length(); i++) {
                int minIdx = Integer.MAX_VALUE;
                char c = str.charAt(i);
                for (String map : keymap) {
                    int newIdx = map.indexOf(c);
                    if (minIdx > newIdx && newIdx != -1) {
                        minIdx = newIdx;
                    }
                }
                if (minIdx == Integer.MAX_VALUE) {
                    answer[j] = -1;
                    break;
                }
                answer[j] += minIdx + 1;
            }
        }
        return answer;
    }
}