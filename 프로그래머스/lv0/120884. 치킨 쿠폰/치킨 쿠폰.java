class Solution {

    public int solution(int chicken) {
        int answer = 0;

        int service = chicken / 10;
        int coupon = chicken % 10;

        while (service > 0) {
            answer += service;
            coupon += service % 10;
            service /= 10;
        }

        while (coupon > 9) {
            answer += coupon / 10;
            int tmp = coupon % 10;
            coupon /= 10;
            coupon += tmp;
        }

        return answer;
    }
}