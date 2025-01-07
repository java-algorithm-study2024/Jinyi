import java.io.BufferedReader;
import java.io.InputStreamReader;
/*
 * 
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String strs = br.readLine();
		int answer = 0;
		for(String str : strs.split("")) {
			answer += Integer.parseInt(str);
		}
		
		System.out.println(answer);
	}
}
