class Solution {
    public String solution(int a, int b) {
        String[] dayName = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        Integer[] Month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int count = 0;

        for (int i = 0; i < a - 1; i++) {
            count += Month[i];
        }

        count += b + 4;
        count %= 7;

        return dayName[count];
    }
}