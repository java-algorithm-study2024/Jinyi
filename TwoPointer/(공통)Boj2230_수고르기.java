import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 7 : 40
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	
		int m = Integer.parseInt(st.nextToken());	
		int[] arr = new int[n];

		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int ans = Integer.MAX_VALUE;
		int s = 0, e = 0;
		while(e < n) {
			//System.out.println(s + " " + e);
			int diff = arr[e] - arr[s];
			if(diff < m) {
				e++;
				continue;
			} else if(diff == m) {
				ans = m;
				break;
			}
			ans = Math.min(ans, diff);
			s++;
		}
		System.out.println(ans);
	}
}
