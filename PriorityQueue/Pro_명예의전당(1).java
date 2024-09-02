import java.util.*;

class Solution {
    public int[] solution(int k, int[] score_arr) {
        PriorityQueue<Score> pq = new PriorityQueue<>();
        int[] answer = new int[score_arr.length];
        
        for(int i = 0; i < score_arr.length; i++) {
            if(i < k) {
                pq.offer(new Score(score_arr[i]));
                answer[i] = pq.peek().score;
            } else {
                if(pq.peek().score < score_arr[i]) {
                    pq.offer(new Score(score_arr[i]));
                    pq.poll();
                }
                answer[i] = pq.peek().score;
            }
        }
        
        return answer;
    }
    
    
}
// 기본적으로 PriorityQueue 는 오름차순 정렬을 해준다.
// 따라서 아래처럼 Comparable 구현을 해주지 않아도 된다.
class Score implements Comparable<Score> {
    int score = 0;
    public Score(int score) {
        this.score = score; 
    }
        
    @Override
    public int compareTo(Score o) {
        return this.score - o.score;
    }
}
