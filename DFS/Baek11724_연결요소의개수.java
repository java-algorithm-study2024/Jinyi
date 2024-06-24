import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static List<Integer> notVisited = new ArrayList<>();
	static Map<Integer, List<Integer>> graph = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st1.nextToken());
		int m = Integer.parseInt(st1.nextToken());
		
		// 노드는 1 ~ n
		for(int i = 0; i < n; i++) {
			notVisited.add(i + 1);
			graph.put(i+1, new ArrayList<>());
		}
		
		// 그래프 생성
		for(int i = 0; i < m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		int answer = 0;
		while(!notVisited.isEmpty()) {
			answer++;
			dfs(notVisited.get(0));
		}
		// 4
		System.out.println(answer);
	}

	// {1=[2], 2=[5], 3=[4], 4=[6], 5=[1], 6=[]}
	private static void dfs(int start) {
		// 4 5 6
		if(notVisited.contains(start)) {
			int idx = notVisited.indexOf(start);
			notVisited.remove(idx);
			for(int i = 0; i < graph.get(start).size(); i++) {
				dfs(graph.get(start).get(i));
			}
		}
	}
}
