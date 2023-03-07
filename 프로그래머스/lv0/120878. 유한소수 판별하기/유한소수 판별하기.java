class Solution {
    public int solution(int a, int b) {
        int m = a;
        int mb = b;

        while(mb != 0){
            int tmp = m % mb;
            m = mb;
            mb = tmp;
        }

        int newB = b / m;
        
        while (newB != 1) {
            if (newB % 2 == 0) {
                newB /= 2;
            } else if (newB % 5 == 0) {
                newB /= 5;
            } else {
                return 2;
            }
        }

        return 1;
    }
}