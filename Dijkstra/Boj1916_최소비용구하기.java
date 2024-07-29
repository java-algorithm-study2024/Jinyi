import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 인접리스트
	static Map<Integer, ArrayList<Node>> graph = new HashMap<>();
	static int[] dp;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		dp = new int[n+1];
		visited = new boolean[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for(int i = 0; i < n; i++) {
			graph.put(i+1, new ArrayList<>());
		}
		
		// 단방향 인접 리스트
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int nodeA = Integer.parseInt(st.nextToken());
			int nodeB = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(nodeA).add(new Node(nodeB, cost));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
//		System.out.println(dist);
//		System.out.println(visited);
//		System.out.println(graph);
		dijkstra(start, end);
		System.out.println(dp[end]);
	}
	
	// 다익스트라 알고리즘
	private static void dijkstra(int start, int end) {
		Queue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dp[start] = 0;
		
		while(!pq.isEmpty()) {
			Node currNode = pq.poll();
			
			if(!visited[currNode.to]) {
				// 1. 방문처리
				visited[currNode.to] = true;
				// 2. dp 갱신
				for(Node node : graph.get(currNode.to)) {
					if(dp[node.to] > dp[currNode.to] + node.cost) {
						dp[node.to] = dp[currNode.to] + node.cost;
						// 3. pq 갱신
						pq.offer(new Node(node.to, dp[node.to]));
					}
				}
			}
		}
	}
}

class Node implements Comparable<Node> {
	int to;
	int cost;
	Node(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}
	
	// pq에 넣을 때 자동으로 cost 기준으로 우선순위 정렬
	@Override
	public int compareTo(Node o) {
		// 오름차순
		return this.cost - o.cost;
	}
}
