class Solution {
    public boolean solution(String s) {
        if(s.length() == 4 || s.length() == 6){
            String  ns = s.replaceAll("[0-9]", "");
        
            return ns.length() == 0;   
        }
        return false;
    }
}