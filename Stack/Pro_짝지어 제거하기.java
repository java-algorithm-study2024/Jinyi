import java.util.*;

class Solution
{
    public int solution(String s)
    {
        String[] strs = s.split("");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for(String str : strs) {
            if(stack.isEmpty()) {
                stack.push(str);
            } else if(str.equals(stack.peek())) {
                stack.pop();
            } else stack.push(str);
        }
    
        if(stack.isEmpty()) return 1;
        return 0;
    }
}
