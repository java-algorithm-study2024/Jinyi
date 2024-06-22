import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		int answer = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][m];
			
			// 배열 완성
			for(int j = 0; j < k; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st2.nextToken()); 
				int y = Integer.parseInt(st2.nextToken()); 
				arr[y][x] = 1;
			}
			for(int j = 0; j < n; j++) {
				for(int l = 0; l < m; l++) {
					if(arr[j][l] == 1) {
						answer++;
						arr[j][l] = 0;
						dfs(arr, j, l);
					}
				}
			}
			bw.write(answer + "");
			bw.write("\n");
			answer = 0;
		}
		bw.flush();
		bw.close();
	}

	private static void dfs(int[][] arr, int x, int y) {
		// 상하좌우
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		for(int i = 0; i < 4; i++) {
			if(x + dx[i] < 0 || x + dx[i] >= arr.length || y + dy[i] < 0 || y + dy[i] >= arr[0].length) continue;
			if(arr[x+dx[i]][y+dy[i]] == 1) {
				arr[x+dx[i]][y+dy[i]] = 0;
				dfs(arr, x+dx[i], y+dy[i]);
			}
		}

	}
}
