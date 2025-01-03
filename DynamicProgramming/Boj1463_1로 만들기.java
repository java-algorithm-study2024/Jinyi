import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];
		
		for(int i = 2; i < n + 1; i++) {
			dp[i] = dp[i - 1] + 1;
			if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
			if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
		}
		
		System.out.println(dp[n]);
	}
}

/*
	
	n = 10
	
	0 : 0
	1 : 0
	2 : 1, 1 -> 1
	3 : 2, 1 -> 1
	4 : 2, 2 -> 2
	5 : 3 -> 3
	6 : 4, 2, 2 -> 최솟값
	
	
*/
