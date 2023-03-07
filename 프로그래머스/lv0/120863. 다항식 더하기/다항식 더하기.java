import java.util.*;

class Solution {

    public String solution(String polynomial) {
        String[] arr = polynomial.split(" \\+ ");

        List<String> xList = new ArrayList<>();
        List<String> numList = new ArrayList<>();

        for (String str : arr) {
            if (str.contains("x")) {
                xList.add(str);
            } else {
                numList.add(str);
            }
        }

        int xSum = 0;
        int nSum = 0;

        for (String str : xList) {
            if (str.length() == 1) {
                xSum++;
            } else {
                String[] st = str.split("x");
                xSum += Integer.parseInt(st[0]);
            }
        }

        for (String str : numList) {
            nSum += Integer.parseInt(str);
        }
        
        String x = String.valueOf(xSum);

        if (xSum == 1) {
            x = "";
        }
        
        if (nSum == 0) {
            return x + "x";
        } else if (xSum == 0) {
            return String.valueOf(nSum);
        } else {
            return x + "x + " + nSum;
        }
    }
}