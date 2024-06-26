import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static boolean[] isVisited;
	static Map<Integer, List<Integer>> graph = new HashMap<>();
	static int answer = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean[n];
		// 노드는 0 ~ n - 1
		for(int i = 0; i < n; i++) {
			graph.put(i, new ArrayList<>());
		}
		
		// 그래프 생성
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		int depth = 0;
		//System.out.println(graph);
		
		for(int i = 0; i < n; i++) {
			dfs(i, depth);
			if(answer == 1) break;
			for(int j = 0; j < n; j++) {
				isVisited[j] = false;
			}
		}
		
		System.out.println(answer);
	}

	private static void dfs(int start, int depth) {
		isVisited[start] = true;
		if(depth >= 4) {
			answer = 1;
			return;
		}
		for(int i = 0; i < graph.get(start).size(); i++) {
			// 아래 재귀 자리에 depth + 1 대신 ++depth 를 쓰면 롤백처럼 구현되는 게 아니라, 계속 depth라는 변수가 증가되는 꼴이 됨
			// 증감연산자로 구현하면 안 됨.
			if(!isVisited[graph.get(start).get(i)]) dfs(graph.get(start).get(i), depth+1);
		}
		isVisited[start] = false;	// rollback
	}
}
