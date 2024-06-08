import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static ArrayDeque<String> q = new ArrayDeque<String>();
	static StringBuilder sb = new StringBuilder();
	
	public static void push(String x) {
		q.offer(x);
	}
	
	public static String back() {
		if(q.isEmpty()) return "-1";
		return q.peekLast();
	}
	
	public static String front() {
		if(q.isEmpty()) return "-1";
		return q.peek();
	}
	
	public static String empty() {
		if(q.isEmpty()) return "1";
		return "0";
	}
	
	public static int size() {
		return q.size();
	}
	
	public static String pop() {
		if(q.isEmpty()) return "-1";
		return q.poll();
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String x = null;
		
		for(int i = 0; i < n; i++) {
			String order = br.readLine();
			StringTokenizer st = new StringTokenizer(order);
			if(st.countTokens() > 1) {
				order = st.nextToken();
				x = st.nextToken();
			}
			
			if("push".equals(order)) push(x);
			else if("pop".equals(order)) sb.append(pop()).append("\n");
			else if("size".equals(order)) sb.append(size()).append("\n");
			else if("empty".equals(order)) sb.append(empty()).append("\n");
			else if("front".equals(order)) sb.append(front()).append("\n");
			else sb.append(back()).append("\n");
		}
		System.out.println(sb);
	}
}
