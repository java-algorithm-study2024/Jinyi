import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 이진 탐색으로 안 품 -> 이진탐색으로 풀어서 다시 커밋하기
public class Main {
	public static void main(String[] args) throws Exception {
		Map<Integer, Integer> map = new HashMap<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			int card = Integer.parseInt(st.nextToken());
			if(map.containsKey(card)) map.replace(card, map.get(card) + 1);
			else map.put(card, 1);
		}
		
		//System.out.println(map);
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			int card = Integer.parseInt(st.nextToken());
			if(map.containsKey(card)) sb.append(map.get(card) + " ");
			else sb.append(0 + " ");
		}
		
		System.out.println(sb);
	}
}
