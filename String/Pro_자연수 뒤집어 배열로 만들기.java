import java.util.*;
class Solution {
    public int[] solution(long n) {
		StringBuilder sb = new StringBuilder(String.valueOf(n));
        int[] answer = Arrays.stream(sb.reverse().toString().split("")).mapToInt(Integer::parseInt).toArray();
		
        return answer;
    }
}
/*
class Solution {
    public int[] solution(long n) {
		String nn = n + "";
		int[] answer = new int[nn.length()];
		int i = 0;
		while(n > 0) {
			answer[i] = (int) (n % 10);
			n /= 10;
			i++;
		}
		
        return answer;
    }
}
*/
