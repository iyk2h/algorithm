import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        List<String> cache = new ArrayList<>();

        for(String city : cities){
            city = city.toUpperCase();
            if (cache.contains(city)) {
                answer++;
                cache.remove(city);
                cache.add(city);
            } else {
                answer += 5;
                if (cacheSize != 0) {
                    if (cache.size() == cacheSize) {
                        cache.remove((int)0);
                    }
                    cache.add(city);
                }
            }
        }
        return answer;
    }
}