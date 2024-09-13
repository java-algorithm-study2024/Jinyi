import java.util.*;

class Solution {
    public long solution(int[] sequence) {       
        long[] ps1 = new long[sequence.length + 1];
        long[] ps2 = new long[sequence.length + 1];
        int a = 1, b = -1;
        for(int i = 1; i < sequence.length + 1; i++) {
            ps1[i] = (long)sequence[i-1] * b;
            ps2[i] = (long)sequence[i-1] * a;
            b *= -1;
            a *= -1;
        }
        
        // 일단, 한 바퀴 쭉 훓는 과정 속에서 해결할 수 있는 아이디어를 고민해보는 습관
        // 전체 누적합이 아니라 부분 누적합 구하기
        long answer = Math.max(ps1[1], ps2[1]);
        for(int i = 2; i < sequence.length + 1; i++) {
            if(ps1[i] < ps1[i - 1] + ps1[i]) ps1[i] += ps1[i-1];
            if(ps2[i] < ps2[i - 1] + ps2[i]) ps2[i] += ps2[i-1];
            
            answer = Math.max(answer, Math.max(ps1[i], ps2[i]));
        }
        
        
        return answer;
    }
}
