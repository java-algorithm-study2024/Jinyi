import java.util.*;

class Solution {
    
    public int solution(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        int answer = fib_topdown(n, memo);
        return answer;
    }
    
    public static int fib_topdown(int n, Map<Integer, Integer> memo){
        if(memo.containsKey(n)) {
            return (memo.get(n) % 1234567);
        }
        if(n < 2) memo.put(n, n);
        else memo.put(n, fib_topdown(n-1, memo) + fib_topdown(n-2, memo));
        
        return (memo.get(n) % 1234567);
    }
}
