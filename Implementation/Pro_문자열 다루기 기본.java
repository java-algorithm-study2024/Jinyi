class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length() != 4 && s.length() != 6) return false;
        
        for(int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if(num < 0 || num > 9) {
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}

// 다른 풀이
class Solution {
    public boolean solution(String s) {
        if(s.length() == 4 || s.length() == 6) {
            try {
                int x = Integer.parseInt(s);
                return true;
            } catch(Exception e) {
                
            }
        }
        return false;
    }
}
