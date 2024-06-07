import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String x = null;
		Queue q = new Queue();
		
		for(int i = 0; i < n; i++) {
			String order = br.readLine();
			StringTokenizer st = new StringTokenizer(order);
			if(st.countTokens() > 1) {
				order = st.nextToken();
				x = st.nextToken();
			}
			
			if("push".equals(order)) q.push(x);
			else if("pop".equals(order)) q.pop();
			else if("size".equals(order)) q.size();
			else if("empty".equals(order)) q.empty();
			else if("front".equals(order)) q.front();
			else q.back();
		}
	}
}

class Queue {
	private List<String> q = new LinkedList<>();

	public void push(String x) {
		q.add(x);
	}

	public void back() {
		if(q.size() == 0) System.out.println(-1);
		else System.out.println(q.get(q.size()-1));
	}

	public void front() {
		if(q.size() == 0) System.out.println(-1);
		else System.out.println(q.get(0));
	}

	public void empty() {
		if(q.size() == 0) System.out.println(1);
		else System.out.println(0);
	}

	public void size() {
		System.out.println(q.size());
	}

	public void pop() {
		if(q.size() == 0) System.out.println(-1);
		else System.out.println(q.remove(0));
	}
	
}
