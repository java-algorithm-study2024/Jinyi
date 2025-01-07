import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
	40 80 60
	=> (40 + 80 + 60) / 3
	=> ((40 + 80 + 60)/80 * 100) / 3
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] scores = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int max_num = 0;
		int answer = 0;
		for(int score : scores) {
			max_num = Math.max(score, max_num);
			answer += score;
		}
		
		System.out.println((answer/(float)max_num * 100) /n);
	}
}
