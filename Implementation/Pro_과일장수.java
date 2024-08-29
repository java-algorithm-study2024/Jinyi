import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Integer[] new_score = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(new_score, Collections.reverseOrder());

        int idx = m-1, answer = 0;
        while(idx < new_score.length) {
            answer += (new_score[idx] * m);
            idx += m;
        }
        
        return answer;
    }
}
