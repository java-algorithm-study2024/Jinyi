import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long s = 0;
        long e = ((long)n % times.length == 0) ? ((long)n / times.length * times[times.length-1]) : ((long)n / times.length * times[times.length-1] + 1l);
        //System.out.println(e);
        
        while(s <= e) {
            long mid = (s + e) / 2;
            long sum = 0;
            for(int i = 0; i < times.length; i++) {
                sum += (mid/times[i]);
            }
            if(sum < n) s = mid + 1l;
            else {
                answer = mid;
                e = mid - 1l;
            }
        }
        
        return answer;
    }
}
