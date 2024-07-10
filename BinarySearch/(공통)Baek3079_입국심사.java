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
		long[] arr = new long[n];
		for(int i = 0; i < n; i++ ) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);
		
		long ans = 0l;
		long start = 0l;
		// 처음에는 arr[n-1] * m 을 end 값으로 정해줬는데, 오버플로가 났던 모양이다.
		// end 값을 최댓값이 아니라 최솟값으로 지정하는게 맞음
		long end = arr[0] * (long)m;
		
		while(start <= end) {
			// mid = 2 -> 0
			long mid = (start + end) / 2l;
			long sum = 0l;
			for(int i = 0; i < n; i++) {
				sum += (mid / arr[i]);
			}
			
			if(sum >= m) {
				ans = mid;
				end = mid - 1;
			}
			else start = mid + 1;
		}
		System.out.println(ans);
	}
}
