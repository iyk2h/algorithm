class Solution {

    public int[] solution(String[] wallpaper) {
        int startH = -1;
        int lastH = -1;

        int startW = Integer.MAX_VALUE;
        int lastW = -1;

        for (int i = 0; i < wallpaper.length; i++) {
            String str = wallpaper[i];
            if (str.contains("#")) {
                if (startH == -1) {
                    startH = i;
                }
                lastH = i + 1;

                for (int j = 0; j < str.length(); j++) {
                    if ('#' == str.charAt(j)) {
                        if (startW > j) {
                            startW = j;
                        }
                        if (lastW <= j) {
                            lastW = j + 1;
                        }
                    }
                }
            }
        }

        return new int[]{startH, startW, lastH, lastW};
    }
}