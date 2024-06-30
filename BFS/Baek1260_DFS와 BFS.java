import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;



public class Main {
	static Map<Integer, List<Integer>> graph = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	static List<Integer> notVisited = new ArrayList<>();
	static ArrayDeque<Integer> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n; i++) {
			graph.put(i+1, new ArrayList<>());
			notVisited.add(i+1);
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		for(int i = 0; i < n; i++) {
			Collections.sort(graph.get(i+1));
		}
		//System.out.println(graph);
		
		visited =  new boolean[n + 1];
		dfs(v);
		sb.append("\n");
		
		visited =  new boolean[n + 1];
		bfs(v);
		
		System.out.println(sb);
	}

	private static void dfs(int v) {
		if(!visited[v]) {
			sb.append(v + " ");
			visited[v] = true;
			for(int i = 0; i < graph.get(v).size(); i++) {
				dfs(graph.get(v).get(i));
			}
		}
	}
	
	private static void bfs(int v) {
		q.offer(v);
		visited[v] = true;
		sb.append(v + " ");
		
		while(!q.isEmpty()) {
			v = q.remove();
			for(int node : graph.get(v)) {
				if(!visited[node]) {
					q.offer(node);
					visited[node] = true;
					sb.append(node + " ");
				}
			}
		}
	}

}
