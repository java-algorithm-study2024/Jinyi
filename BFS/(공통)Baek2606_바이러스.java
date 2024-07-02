import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;



public class Main {
	static Map<Integer, List<Integer>> graph = new HashMap<>();
	static ArrayDeque<Integer> q = new ArrayDeque<>();
	static boolean[] isVisited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			graph.put(i+1, new ArrayList<>());
		}
		
		int e = Integer.parseInt(br.readLine());
		for(int i = 0; i < e; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		//System.out.println(graph);
		
		isVisited = new boolean[n+1];
		System.out.println(bfs(1));
	}

	private static int bfs(int v) {
		int cnt = 0;
		q.offer(v);
		isVisited[v] = true;
		
		while(!q.isEmpty()) {
			v = q.remove();
			for(int i = 0; i < graph.get(v).size(); i++) {
				if(!isVisited[graph.get(v).get(i)]) {
					cnt++;
					isVisited[graph.get(v).get(i)] = true;
					q.add(graph.get(v).get(i));
				}
			}
		}
		return cnt;
	}
}
