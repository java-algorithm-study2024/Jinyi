import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static boolean[] visited;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		visited = new boolean[n + 1];


		dfs(0);
		System.out.println(sb);
	}
	
	private static void dfs(int depth) {
		if(depth == m) {
			for(int i : arr) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}
	
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[depth] = i;
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
}
