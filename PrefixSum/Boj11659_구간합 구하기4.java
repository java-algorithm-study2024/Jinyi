import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
	40 80 60
	=> (40 + 80 + 60) / 3
	=> ((40 + 80 + 60)/80 * 100) / 3
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] ps = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < n+1; i++) {
			ps[i] = ps[i-1] + Integer.parseInt(st.nextToken());
		}
		
		// 0 5 4 3  2  1
		// 0 5 9 12 14 15
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int idx1 = Integer.parseInt(st.nextToken());
			int idx2 = Integer.parseInt(st.nextToken());
			String str = String.valueOf(ps[idx2] - ps[idx1 - 1]);
			sb.append(str).append("\n");
		}
		
		
		System.out.println(sb);
	}
}
