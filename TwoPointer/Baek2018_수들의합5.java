import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0, intervalSum = 0, end = 1;
		
		// start 포인터를 하나씩 증가시키면서 반복
		for(int start = 1; start <= n; start++) {
			while(intervalSum < n && end <= n) {	// 가능한 만큼 end 포인터 이동
				intervalSum += end;
				end += 1;
			}
			// 부분합 = n 인 경우
			if(intervalSum == n) cnt++;
			intervalSum -= start;
		}
		System.out.println(cnt);
	}
}
