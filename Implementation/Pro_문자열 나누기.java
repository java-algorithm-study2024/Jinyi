import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        ArrayDeque<String> q = new ArrayDeque<>(Arrays.asList(s.split("")));
        //System.out.println(q);
        while(!q.isEmpty()) {
            String ch1 = q.poll();
            int num1 = 1, num2 = 0;
            while(num1 != num2) {
                if(q.isEmpty()) break;
                
                String ch2 = q.poll();
                if(ch1.equals(ch2)) num1++;
                else num2++;
            }
            answer++;
        }
        return answer;
    }
}
