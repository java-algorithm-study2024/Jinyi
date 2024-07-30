import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Map<Integer, List<Node>> graph = new HashMap<>();
	static int[] dp;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		visited = new boolean[v+1];
		dp = new int[v+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for(int i = 0; i < v; i++) {
			graph.put(i+1, new ArrayList<>());
		}
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(x).add(new Node(y, w));
		}
		
		dijkstra(start);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < v+1; i++) {
			if(dp[i] != Integer.MAX_VALUE) sb.append(dp[i]).append("\n");
			else sb.append("INF\n");
		}
		System.out.println(sb);
	}
	
	// 다익스트라
	private static void dijkstra(int start) {
		Queue<Node> pq = new PriorityQueue<>();
		dp[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			if(!visited[curNode.to]) {
				// 1. 방문처리
				visited[curNode.to] = true;
				for(Node nextNode : graph.get(curNode.to)) {
					// 2. dp 갱신
					// 현재 방문한 노드를 거쳐서 가는 경우의 거리 비교
					if(dp[nextNode.to] > dp[curNode.to] + nextNode.weight) {
						dp[nextNode.to] = dp[curNode.to] + nextNode.weight;
						// 3. pq 갱신
						pq.offer(new Node(nextNode.to, dp[nextNode.to]));
					}
				}
			}
		}
	}
}

class Node implements Comparable<Node> {
	int to;
	int weight;
	
	Node(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}

	// 오름차순
	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
	
}
