import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(A);
		int m = Integer.parseInt(br.readLine());
		int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		StringBuilder sb = new StringBuilder();
		int ans = 0;
		// b = 2
		for(int b : B) {
			
			int start = 0;
			int end = n - 1;
			while(start <= end) {
				// mid = 2 -> 0
				int mid = (start + end) / 2;
				if(A[mid] >= b) {
					ans = mid;
					// end = 1
					end = mid - 1;
				}
				else start = mid + 1;
			}
			if(A[ans] == b) sb.append(1 + " ");
			else sb.append(0 + " ");
		}
		System.out.println(sb);
	}
}
