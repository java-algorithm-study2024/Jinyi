import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String order = br.readLine();
			StringTokenizer st = new StringTokenizer(order);
			while(st.hasMoreTokens()) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}
		}
		
		int result = 0;
		for(int i = 0; i < n; i++) {
			result = pq.poll();
		}
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
}
