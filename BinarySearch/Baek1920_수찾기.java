import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(A);
		
		int m = Integer.parseInt(br.readLine());
		int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		StringBuilder sb = new StringBuilder();
		for(int b : B) {
			if(Arrays.binarySearch(A, b) < 0) sb.append(0 + "\n"); 
			else sb.append(1 + "\n"); 
		}
		
		System.out.println(sb); 
	}
}
