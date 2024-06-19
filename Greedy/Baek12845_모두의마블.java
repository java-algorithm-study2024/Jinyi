import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
		Integer[] cards = Arrays.stream(arr).boxed().toArray(Integer[]::new);
    
		Arrays.sort(cards, Collections.reverseOrder());
    
		int max = cards[0];
		int sum = 0;
		for(int i = 1; i < cards.length; i++) {
			sum += (max + cards[i]);
		}
		System.out.println(sum);
    }
}
