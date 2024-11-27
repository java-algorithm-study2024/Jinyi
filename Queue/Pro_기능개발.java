import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        //Queue<Integer> q = new LinkedList<>();
        int max = (int)Math.ceil((100 - progresses[0]) / (double)speeds[0]);
        q.offer(max);
        
        for(int i = 1; i < progresses.length; i++) {
            int day = (int)Math.ceil((100 - progresses[i]) / (double)speeds[i]);
            if(day > max) {
                max = day;
                answer.add(q.size());
                q.clear();
            }
            
            q.offer(day);
        }
        
        answer.add(q.size());
        return answer;
        //return answer.stream().mapToInt(Integer:: intValue).toArray();
    }
}
