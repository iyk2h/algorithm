import java.util.ArrayList;

class Solution {
    public int solution(int[] ingredient) {
        
        int answer = 0;
        ArrayList<Integer> hamList = new ArrayList<>();
        
        ArrayList<Integer> result = new ArrayList<>();
        
        result.add(1);
        result.add(2);
        result.add(3);
        result.add(1);
        
        for(int i = 0; i < ingredient.length; i++) {
        	hamList.add(ingredient[i]);
        	
        	if(hamList.size() >= 4) {
        		ArrayList<Integer> tempList = new ArrayList<>();
        		tempList.add(hamList.get(hamList.size()-4));
        		tempList.add(hamList.get(hamList.size()-3));
        		tempList.add(hamList.get(hamList.size()-2));
        		tempList.add(hamList.get(hamList.size()-1));
        		
        		if(tempList.equals(result)) {
        			answer++;
        			
        			hamList.remove(hamList.size()-1);
        			hamList.remove(hamList.size()-1);
        			hamList.remove(hamList.size()-1);
        			hamList.remove(hamList.size()-1);
        		}
        	}	
        }
        
        return answer;
    }
}