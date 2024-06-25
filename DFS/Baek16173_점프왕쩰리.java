import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static boolean ch = false;
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		
		dfs(0, 0, map[0][0]);
		
		if(ch) System.out.println("HaruHaru");
		else System.out.println("Hing");
	}

	static void dfs(int x, int y, int k) {
		int[] dx = {0, k};
		int[] dy = {k, 0};
		
		for(int i = 0; i < 2; i++) {
			int ax = x + dx[i];
			int ay = y + dy[i];
			
			if(ax >= n || ay >= n) continue;
			if(map[ax][ay] == -1) {
				ch = true;
				return;
			}
			
			if(!visited[ax][ay]) {
				visited[ax][ay] = true;
				dfs(ax, ay, map[ax][ay]);
			}
		}
	}
}
