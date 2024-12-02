import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        while(n != 1) {
            if(n % 2 == 0) {
                n /= 2;
            } else {
                n /= 2;
                ans++;
            }
        }
        return ans + 1;
    }
}
/*
    재귀
    n = 5000
    
    1. n = 5000 = 짝수 = 2500 = 짝수 = 1250 = 짝수 = 625 = 홀수
    2. 625 = 홀수 => 312 + 1
    3. 312 = 짝수 = 156 = 짝수 = 78 = 짝수 = 39
    4. 39 = 홀수 => 19 + 1
    5. 19 = 홀수 => 9 + 1
    6. 9 = 홀수 => 4 + 1
    7. 4 = 짝수 = 2 = 짝수 = 1 = 1
*/
