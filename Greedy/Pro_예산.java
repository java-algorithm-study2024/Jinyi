import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int support = 0;
        int answer = 0;
        for(int i : d) {
            support += i;
            if(support > budget) break;
            answer++;
        }
        return answer;
    }
}
