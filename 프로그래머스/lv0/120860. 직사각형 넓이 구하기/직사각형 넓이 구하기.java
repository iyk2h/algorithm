class Solution {
    public int solution(int[][] dots) {

        int w = Math.max( Math.abs(dots[0][0] - dots[1][0]) , Math.abs(dots[0][1] - dots[1][1]) );
        int h = Math.max( Math.abs(dots[1][0] - dots[2][0]) , Math.abs(dots[1][1] - dots[2][1]) );

        return w * h;
    }
}