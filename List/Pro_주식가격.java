import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] prices) {
		int n = prices.length;
		int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
        	list.add(prices[i]);
        }
        
        for(int i = 0; i < n; i++) {
        	int v = list.get(i);
        	for(int j = i+1; j < n; j++) {
        		if(v > list.get(j)) {
        			answer[i] = j - i;
        			break;
        		}
        		
        		if(j == n-1) {
        			answer[i] = j - i;
        		}
        	}
        }
        return answer;
    }
}
