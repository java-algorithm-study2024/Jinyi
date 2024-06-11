import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
	static boolean[] isVisited;
	static int[] result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		isVisited = new boolean[n];
		result = new int[n];
		// 인접 리스트
		List<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < n; i++) {
			tree.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree.get(a - 1).add(b);
			tree.get(b - 1).add(a);
		}
//		for(int i = 1; i < n + 1; i++) {
//			System.out.println(tree.get(i).toString());
//		}
		dfs(1, tree);
		
		for(int i = 1; i < n; i++) {
			bw.write(String.valueOf(result[i])); bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int start, List<ArrayList<Integer>> tree) {
		if(!isVisited[start-1]) {
			isVisited[start-1] = true;
			for(int i = 0; i < tree.get(start-1).size(); i++) {
				int x = tree.get(start-1).get(i);
				if(!isVisited[x - 1]) {
					dq.offer(x);
					result[x - 1] = start;
				}
			}
		}
		if(!dq.isEmpty()) {
			dfs(dq.poll(), tree);
		}
	}
}
