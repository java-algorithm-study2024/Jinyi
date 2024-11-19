import java.util.*;
class Solution {
    public int solution(int num) {
        int answer = 0;
        long num_l = (long)num;
        if(num == 1) return answer;
        
        for(int i = 0; i < 500; i++) {
            if(num_l % 2 == 0) num_l /= 2;
            else num_l = num_l * 3 + 1l;
            
            answer++;
            if(num_l == 1) {
                break;
            }
            
        }
        System.out.println(num_l);
        
        if(num_l != 1) return -1;
        return answer;
    }
}
