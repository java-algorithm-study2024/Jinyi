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
		int max_num = 0;
		int max_i = 0;
		int max_j = 0;
		for(int i = 0; i < 9; i++) {
			int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int j = 0; j < 9; j++) {
				if(max_num < row[j]) {
					max_num = row[j];
					max_i = i;
					max_j = j;
				}
			}
		}
		System.out.println(max_num + "\n" + (max_i + 1) + " " + (max_j + 1));
	}
}
