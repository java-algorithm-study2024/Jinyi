import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static Map<Integer, List<Integer>> graph = new HashMap<>();
	static int[] dp;
	static boolean[] visited;
	static List<Integer> result = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		dp = new int[n+1];
		visited = new boolean[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for(int i = 0; i < n; i++) {
			graph.put(i+1, new ArrayList<>());
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
		}
		//System.out.println(graph);
		
		
		dijkstra(x, k);
		
		if(result.isEmpty()) System.out.println(-1);
		else {
			Collections.sort(result);
			for(int r : result) {
				System.out.println(r);
			}
		}
	}
	
	// 다익스트라
	private static void dijkstra(int start, int k) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(start);
		dp[start] = 0;
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int node2 : graph.get(node)) {
				if(!visited[node2]) {
					visited[node2] = true;
					dp[node2] = dp[node] + 1;
					q.offer(node2);
					
					if(dp[node2] == k) result.add(node2);
				}
			}
		}
		
	}
}
