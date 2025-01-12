import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		int p1 = 0, p2 = 1;
		int[] arr = new int[n+1];
		for(int i = 1; i < n + 1; i++) {
			arr[i] = arr[i-1] + i;
		}
		
		while(p2 <= n) {
			if(arr[p2] - arr[p1] < n) p2++;
			else if(arr[p2] - arr[p1] > n) p1++;
			else {
				answer++;
				p1++; p2++;
			}
		}
		System.out.println(answer);
	}
}

/*
	idx 0, 1 에서 시작
	sum = idx1의 값
	p2의 값 <= n 일때까지 반복
	1) sum < n, p2++ / sum += p2값
	2) sum > n, p1++ / sum -= p1값
	3) sum = n, p1++, p2++ / 1, 2 값 갱신
*/
