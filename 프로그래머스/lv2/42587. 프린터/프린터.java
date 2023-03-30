import java.util.*;

class Solution {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Struct> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            Struct map = new Struct(i, priorities[i]);
            queue.add(map);
        }

        while (!queue.isEmpty()) {

            boolean flag = false;

            for (Struct map : queue) {
                if (map.value > queue.peek().value) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                queue.add(queue.poll());
            } else {
                answer++;
                if (queue.poll().key == location) {
                    return answer;
                }
            }
        }
        return answer;
    }
}

class Struct {

    int key;
    int value;

    public Struct(int key, int value) {
        this.key = key;
        this.value = value;
    }
}