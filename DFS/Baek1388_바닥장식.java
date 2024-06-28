import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] isVisited;
	static String[][] floor;
	static int answer = 0;
	static int n;
	static int m;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean[n][m];
		floor = new String[n][m];
		// 그래프 생성
		for(int i = 0; i < n; i++) {
			floor[i] = br.readLine().split("");
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!isVisited[i][j]) {
					dfs(i, j, floor[i][j]);
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
	// n : 세로, x
	// m : 가로, y
	private static void dfs(int x, int y, String f) {
		isVisited[x][y] = true;
		// 오른쪽 방향 우선 탐색
		if("-".equals(f) && y+1 < m && "-".equals(floor[x][y+1])) {
			dfs(x, y+1, f);
		} else if("|".equals(f) && x+1 < n && "|".equals(floor[x+1][y])) {    // 아래쪽 방향 우선 탐색
			dfs(x+1, y, f);
		}
	}
}
