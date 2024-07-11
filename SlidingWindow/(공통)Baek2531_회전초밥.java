import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] chobap = new int[n];
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			chobap[i] = Integer.parseInt(br.readLine());
			map.put(chobap[i], 0);
		}
		// 주어진 쿠폰번호에 해당하는 초밥이 회전초밥 벨트 위에 없을 수도 있음 -> replace() 사용하면 nullPointer예외 남.
		map.put(c, 1);
		//map.replace(c, 1);
		
		int max = 0;
		int change = 1;
		for(int i = 0; i < k; i++) {
			int value = map.get(chobap[i]);
			if(value == 0) change++;
			map.replace(chobap[i], value + 1);
		}
		if(max < change) max = change;
		
		//System.out.println(map);
		//System.out.println(max + " " + change);
		for(int i = 1; i < n; i++) {
			int value = map.get(chobap[i-1]);
			if(value - 1 <= 0) change--;
			map.replace(chobap[i-1], value - 1);
			
			value = map.get(chobap[(i+k-1) % n]);
			if(value <= 0) change++;
			map.replace(chobap[(i+k-1) % n], value + 1);
			
			if(map.get(c) == 0) change++;
			if(max < change) max = change;
		}
		
		System.out.println(max);
	}
}
