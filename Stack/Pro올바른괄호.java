import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if('(' == ch) {
                stack.add(ch);
            } else {
                if(stack.size() > 0) stack.pop();
                else answer = false;
            }
        }
        if(stack.size() > 0) answer = false;
        
        return answer;
    }
}
