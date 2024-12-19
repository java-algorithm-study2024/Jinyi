import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int n;
	static int m;
	static int[][] graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n][m];
		// 그래프 완성
		for(int i = 0; i < n; i++) {
			int[] ints = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			graph[i] = ints;
		}
		//System.out.println(graph);
		
		int answer = bfs(0, 0);
		System.out.println(answer);
	}
	
	// bfs with queue
	public static int bfs(int x, int y) {
		ArrayDeque<Node> q = new ArrayDeque<>(); 
		q.offer(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			x = node.getX();
			y = node.getY();
			
			for(int i = 0; i < 4; i++) {
				int ax = x + dx[i];
				int ay = y + dy[i];
				
				if(ax < 0 || ax >= n || ay < 0 || ay >= m) continue;
				if(graph[ax][ay] != 1) continue;
				
				q.offer(new Node(ax, ay));
				graph[ax][ay] = graph[x][y] + 1;
			}
		}
		return graph[n-1][m-1];
	}
}

class Node {
	public int x;
	public int y;
	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}
