import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			q.offer(i+1);
		}
		int i = 0;
		while(q.size() != 1) {
			if(i % 2 == 0) q.poll();
			else {
				int a = q.poll();
				q.offer(a);
			}
			i++;
		}
		System.out.println(q.peek());
	}
}
