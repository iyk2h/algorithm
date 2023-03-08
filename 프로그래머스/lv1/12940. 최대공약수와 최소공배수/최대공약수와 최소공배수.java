class Solution {

    public int[] solution(int n, int m) {

		int d = gcd(n, m);
 
        
        return new int[]{d, n * m / d};
 
	}
 
	public int gcd(int a, int b) {
 
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}