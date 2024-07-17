import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	
		int k = Integer.parseInt(st.nextToken());	
		int[] ps = new int[1000001];
		int min = Integer.MAX_VALUE;
		int max = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(min > a) min = a;
			if(max < b) max = b;
			for(int j = a+1; j <= b; j++) {
				ps[j]++;
			}
		}
		// 누적합 구하기
		for(int i = min + 1; i <= max; i++) {
			ps[i] += ps[i-1];
		}
		// ps = {idx0:0 idx1:2 idx2:4 idx3:6 idx4:10 idx5:14 idx6:18 idx7:22 idx8:26 idx9:29 idx10:32 idx11:33 idx12:34 idx13:35 idx14:36 idx15:37 idx16:0 idx17:0.....}
		
		boolean ch = false;
		// 처음에는 s = min + 1 값으로 설정했는데, 그러면 문제 조건 중 "가능하다면 A가 최솟값"인 경우를 구해야 한다는 조건에 위배됨.
		int s = 1, e = s;
		int sum = 0;
		while(e <= max) {
			sum = ps[e] - ps[s-1];
			if(sum < k) {
				e++;
				continue;
			} else if(sum == k) {
				System.out.println(s - 1 + " " + e);
				ch = true;
				break;
			}
			s++;
		}
		if(!ch) System.out.println("0 0");
	}
}
