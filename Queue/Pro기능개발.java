import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        int max = (int)Math.ceil((100 - progresses[0])/(double)speeds[0]);
        q.offer(max);
        for(int i = 1; i < progresses.length; i++) {
        	int day = (int)Math.ceil((100 - progresses[i])/(double)speeds[i]);
        	if(max < day) {
        		max = day;
        		answer.add(q.size());
        		q.clear();
        	}
        	q.offer(day);
        }
        answer.add(q.size());
        
        return answer.stream().mapToInt(Integer:: intValue).toArray();
    }
}
