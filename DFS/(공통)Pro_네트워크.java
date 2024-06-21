import java.util.ArrayDeque;

class Solution {
    static ArrayDeque<Integer> notVisited = new ArrayDeque<>();
	
	
	public int solution(int n, int[][] computers) {
		int answer = 0;
		
		for(int i = 0; i < n; i ++) {
			notVisited.offer(i);
		}
		
		while(!notVisited.isEmpty()) {
			answer++;
			dfs(n, notVisited.poll(), computers);
		}
        return answer;
    }
	
	static void dfs(int n, Integer start, int[][] computers) {
		for(int i = 0; i < n; i++) {
			if(notVisited.contains(i) && computers[start][i] == 1) {
				notVisited.remove(i);
				dfs(n, i, computers);
			}
		}
	}
}
