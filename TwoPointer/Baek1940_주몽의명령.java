import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		
		int cnt = 0;
		int start = 0, end = arr.length - 1;
		while(start < end) {
			int sum = arr[start] + arr[end];
			if(sum == m) {
				cnt++;
				start++;
				end--;
			} else if(sum < m) {
				start++;
			} else {
				end--;
			}
		}
		System.out.println(cnt);
	}
}
