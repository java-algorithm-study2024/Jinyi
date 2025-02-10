import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	static ArrayDeque<Integer> stack = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long ans = fact(n);
		System.out.println(ans);
	}
	
	static long fact(int n) {
		if(n == 1 || n == 0) return 1;
		return n * fact(n-1);
	}
}
