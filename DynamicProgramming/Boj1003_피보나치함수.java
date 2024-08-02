import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	// 0, 1 이 사용된 갯수 구하기용 prefix sum
	static int[] ps_0;
	static int[] ps_1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < T; i++) {
			int tCase = Integer.parseInt(br.readLine());
			ps_0 = new int[tCase+1];
			ps_1 = new int[tCase+1];
			
			for(int j = 0; j <= tCase; j++) {
				if(j == 0) ps_0[0] = 1;
				else if(j == 1) ps_1[1] = 1;
				else {
					ps_0[j] = ps_0[j-1] + ps_0[j-2];
					ps_1[j] = ps_1[j-1] + ps_1[j-2];
				}
			}
			sb.append(ps_0[tCase] + " " + ps_1[tCase]).append("\n");
		}
		
		System.out.println(sb);
	}
}
