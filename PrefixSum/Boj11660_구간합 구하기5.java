import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] ps = new int[n+1][n+1];
		
		for(int i = 1; i < n + 1; i++) {
			int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int j = 1; j < n+1; j++) {
				ps[i][j] = ps[i][j-1] + temp[j-1];
			}
			for(int j = 1; j < n+1; j++) {
				ps[i][j] += ps[i-1][j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			sb.append(ps[x2][y2] - ps[x1-1][y2] - ps[x2][y1-1] + ps[x1-1][y1-1]).append("\n");
		}
		System.out.println(sb);
	}
}
