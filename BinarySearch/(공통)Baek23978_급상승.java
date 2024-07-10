import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		long k = Long.parseLong(st.nextToken());
		long[] A = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		
		long start = 1L;
		long end = 1414213562L;
		long ans = 0L;
		/*
		 	5 5
		 	1 10 100 1000 10000
		 	
		 	3 10
		 	1 2 4
		*/
		
		while(start <= end) {
			// mid = 2 -> 0
			long mid = (start + end) / 2L;
			long sum = 0L;
			for(int i = 1; i < n; i++) {
				long diff = A[i] - A[i - 1];
				
				if(diff < mid) sum += (long)(mid * (mid + 1L)) / 2L - (long)((mid - diff) * (mid - diff + 1L)) / 2L;
				// diff >= mid 인 경우는 더하는 값의 범위가 mid의 값보다 커지므로 따로 계산한다.
				// 예를 들어 diff = 10 인데, mid = 4인 경우는 sum += (4 + 3 + 2 + 1 + 0 + 0 + 0 + 0 + 0 + 0)이다.
				// -> 즉, 위의 if문은 0이 더해지지 않는 경우의 계산이고, 아래는 0이 더해지는 경우의 계산
				else sum += (long)(mid * (mid + 1L)) / 2L;
				
				if(sum > k) break;
			}
			sum += (long)(mid * (mid + 1L)) / 2L;
			//System.out.println(sum);
			// end = 1
			if(sum >= k) {
				ans = mid;
				end = mid - 1L;
				//System.out.println(mid);
			}
			// start = 
			else start = mid + 1L;
		}
		System.out.println(ans);
	}
}
