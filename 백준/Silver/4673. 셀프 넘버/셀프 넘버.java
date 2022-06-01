public class Main {
    public static void main(String[] args) {

        int a;
        int arr[] = new int[10000];



        for (int i = 0; i < 10000; i++) {
            a = i;
            int sum = a;
            while (a > 0) {
                sum += a % 10;
                a = a / 10;
            }
            if(sum < 10000)
                arr[sum] = 1;
        }
        for (int i = 1; i < 10000; i++) {
            if (arr[i] != 1) {
                System.out.println(i);
            }
        }
    }
}