import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static ArrayDeque<Integer> q = new ArrayDeque<>();
	static boolean[] isVisited;
	static int result = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 인접 리스트
		ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
		int stop = Integer.parseInt(br.readLine());
		int root = 0;
		isVisited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			tree.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < n; i++) {
			if(arr[i] == -1) root = i;
			else {
				tree.get(i).add(arr[i]);
				tree.get(arr[i]).add(i);
			}
		}
		dfs(root, stop, tree);
		
		System.out.println(result);
	}

	private static void dfs(int start, int stop, ArrayList<ArrayList<Integer>> tree) {
		if(start == stop) return;
		isVisited[start] = true;
		boolean check = false;
		
		for(int i = 0; i < tree.get(start).size(); i++) {
			int x = tree.get(start).get(i);
			if(x != stop && !isVisited[x]) {
				q.offer(x);
				check = true;
			}
		}
		if(!check) result++;
		if(!q.isEmpty()) {
			dfs(q.poll(), stop, tree);
		}
	}
}
