import java.util.*;

class Solution {
    public static int solution(int[] picks, String[] minerals) {
        if (Arrays.stream(picks).sum() * 5 < minerals.length) {
            minerals = Arrays.copyOfRange(minerals, 0, Arrays.stream(picks).sum() * 5);
        }

        int[][] counted = scanMinerals(minerals);

        int answer = calculateFatigue(counted, picks);
        return answer;
    }

    public static int[][] scanMinerals(String[] minerals) {
        int i = 0;
        List<int[]> counted = new ArrayList<>();
        boolean flag = true;
        while (flag) {
            String[] target = new String[0];
            if (i + 5 < minerals.length) {
                target = Arrays.copyOfRange(minerals, i, i + 5);
            } else {
                target = Arrays.copyOfRange(minerals, i, minerals.length);
                flag = false;
            }
            int dias = countOccurrences(target, "diamond");
            int irons = countOccurrences(target, "iron");
            int stones = countOccurrences(target, "stone");
            counted.add(new int[]{dias, irons, stones});
            i += 5;
        }

        counted.sort((a, b) -> Integer.compare(b[0], a[0]) != 0 ? Integer.compare(b[0], a[0])
                : Integer.compare(b[1], a[1]));

        return counted.toArray(new int[0][]);
    }

    public static int calculateFatigue(int[][] counted, int[] picks) {
        int result = 0;
        for (int[] target : counted) {
            if (picks[0] > 0) {
                picks[0]--;
                result += Arrays.stream(target).sum();
            } else if (picks[1] > 0) {
                picks[1]--;
                result += target[0] * 5 + target[1] + target[2];
            } else if (picks[2] > 0) {
                picks[2]--;
                result += target[0] * 25 + target[1] * 5 + target[2];
            } else {
                break;
            }
        }
        return result;
    }

    public static int countOccurrences(String[] arr, String str) {
        return (int) Arrays.stream(arr).filter(x -> x.equals(str)).count();
    }
}