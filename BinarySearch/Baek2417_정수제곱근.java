import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		
		long start = 0;
		long end = n;
		long answer = 0;
		// n = 10
		
		while(start < end) {
			long mid = (start + end) / 2;
			if(mid == answer) {
				answer = mid + 1;
				break;
			}
			answer = mid;
			
			// -> Math.pow() 안 쓰고 mid * mid 하면 너무 큰 수에서 제대로 계산이 안 됨.
			//long square = (long)Math.pow(mid, 2); -> double 타입을 long 타입으로 형변환 과정에서 오버플로우 발생
			// -> long 타입의 범위는 2^63까지다.
			if(Math.pow(mid, 2) > n) end = mid;
			else if(Math.pow(mid, 2) < n) start = mid;			
			else break;
		}
		System.out.println(answer); 
	}
}
