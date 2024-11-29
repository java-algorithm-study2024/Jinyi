class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        int p = s.length() - s.replace("p", "").length();
        int y = s.length() - s.replace("y", "").length();
        
        if(p == y) return true;
        return false;
    }
}
