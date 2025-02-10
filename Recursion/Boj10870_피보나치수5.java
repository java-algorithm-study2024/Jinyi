import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long ans = fibo(n);
		System.out.println(ans);
	}
	
	static long fibo(int n) {
		if(n == 0) return 0;
		else if(n == 1) return 1;
		return fibo(n-1) + fibo(n-2);
	}
}
