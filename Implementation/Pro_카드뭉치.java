import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> q1 = new ArrayDeque<>();
        q1.addAll(Arrays.asList(cards1));
        Queue<String> q2 = new ArrayDeque<>();
        q2.addAll(Arrays.asList(cards2));
        
        boolean ch = true;
        
        for(String str : goal) {
            if(!q1.isEmpty() && str.equals(q1.peek())) {
                q1.poll();
                continue;
            } else if(!q2.isEmpty() && str.equals(q2.peek())) {
                q2.poll();
                continue;
            }
            
            ch = false;
        }
        String answer = "";
        if(ch) answer = "Yes";
        else answer = "No";
        
        return answer;
    }
}
