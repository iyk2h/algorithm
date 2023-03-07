class Solution {
    public long solution(long n) {
        double i = Math.sqrt(n);

        if (i % 1 == 0) {
            return (long) Math.pow(i+1, 2);
        } else {
            return -1;
        }
    }
}