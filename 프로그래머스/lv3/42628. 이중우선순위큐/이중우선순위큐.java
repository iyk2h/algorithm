import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
               
        List<Integer> list = new ArrayList<>();
        
        for (String str : operations) {
            String[] sArr = str.split(" ");
            
            if (sArr[0].equals("I")) {
                list.add(Integer.parseInt(sArr[1]));
                Collections.sort(list);
            }else {
                if (list.isEmpty()) continue;
                if (sArr[1].equals("1")) {
                    list.remove((int) list.size() - 1);
                }else {
                    list.remove((int) 0);
                }
            }
        }
        
        if (list.isEmpty()) {
            return new int[] {0, 0};
        }
        
        return new int[]{list.get(list.size() - 1), list.get(0)};
    }
}