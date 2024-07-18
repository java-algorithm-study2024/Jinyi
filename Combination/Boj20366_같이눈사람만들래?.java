import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		List<SnowMan> comb = new ArrayList<>();
		// 1. 조합 생성
		for(int i = 0; i < n-1; i++) {
			for(int j = i + 1; j < n; j++) {
				comb.add(new SnowMan(i, j, arr[i] + arr[j]));
			}
		}
		// 2. 정렬
		Collections.sort(comb, (a, b) -> a.height - b.height);
		
		int min = Integer.MAX_VALUE;
		// 3. 눈사람들이 담긴 list 를 하나씩 돌면서, 양 옆의 원소들과 키차이를 비교한다.
		for(int i = 0; i < comb.size() - 1; i++) {
			SnowMan s1 = comb.get(i);
			SnowMan s2 = comb.get(i+1);
			//  각 눈사람을 구성하는 idx 값들이 모두 다르면서
			if(s1.i != s2.i && s1.i != s2.j && s1.j != s2.i && s1.j != s2.j) {
				int diff = s2.height - s1.height;
				// 키 차이가 최소인 경우를 찾아 업데이트한다.
				if(diff < min) min = diff;
			}
		}
		System.out.println(min);
	}
	
	// 눈사람 클래스 : 눈사람을 구성하는 idx 정보와 키 정보를 갖고 있다.
	static class SnowMan {
		private int i;
		private int j;
		private int height;
		SnowMan(int i, int j, int height) {
			this.i = i;
			this.j = j;
			this.height = height;
		}
	}
}
