class Solution {
    public int solution(int[][] dots) {
        double fx = Math.abs(dots[1][0] - dots[0][0]);
        double fy = Math.abs(dots[1][1] - dots[0][1]);

        double sx = Math.abs(dots[3][0] - dots[2][0]);
        double sy = Math.abs(dots[3][1] - dots[2][1]);

        if ((fy / fx) == (sy / sx)) {
            return 1;
        }

        return 0;
    }
}