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
		
		int answer = 0;
		int[] trees = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int start = 0;
		int end = Arrays.stream(trees).max().getAsInt();
		while(start <= end) {
			int mid = (start + end) / 2;
			long sum = 0;
			for(int i = 0; i < n; i++) {
				if(mid < trees[i]) sum += trees[i] - mid;
			}
			
			if(sum < m) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
				if(mid >= answer) answer = mid;
			}
		}
		System.out.println(answer);
	}
}
