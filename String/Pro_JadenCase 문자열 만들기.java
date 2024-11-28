class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        String[] strs = s.split("");
        s = "";
        boolean bool = true;
        
        for(String str : strs) {
            s += (bool? str.toUpperCase() : str);
            bool = (" ".equals(str)? true: false);
        }
        return s;
    }
}
