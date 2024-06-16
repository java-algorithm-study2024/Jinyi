import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 5가 2의 배수가 아니더라도, 5로 먼저 채우고 짝수만 남기면 2가 처리할 수 있으니까 그리디 정당성이 확인된다.
		int n = Integer.parseInt(br.readLine());
		
		// 28 = 5 * 4 + 2 * 4 -> 8개
		// 29 = 5 * 5 + 2 * 2 -> 7개
		// 1, 3 -> -1
		int answer = 0;
		int temp = n % 5;
		if(n == 1 || n == 3) {
			System.out.println(-1);
			return;
			
		}
		
		if(temp % 2 != 0) {
			answer = n/5 - 1;
			n = (n % 5) + 5;
			answer += n / 2;
		} else {
			answer = n/5;
			n %= 5;
			answer += n / 2;
		}
		
		System.out.println(answer);
	}
}
