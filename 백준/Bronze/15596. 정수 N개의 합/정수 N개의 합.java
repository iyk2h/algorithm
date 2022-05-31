class Test {
    long sum(int[] a) {
        long sum = 0;

        for( int x = 0; x<a.length ; x++ ){
            sum += a[x];
        }
        return sum;
    }
}