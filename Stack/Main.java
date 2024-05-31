package shinhan_study2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static List<Integer> stack = new ArrayList<>();
	public static void push(int x) {
		stack.add(0, x);
	}
	public static int size() {
		return stack.size();
	}
	public static int empty() {
		if(stack.size() == 0) return 1;
		else return 0;
	}
	public static int pop() {
		if(empty() == 1) return -1;
		else return stack.remove(0);
	}
	public static int top() {
		if(empty() == 1) return -1;
		else return stack.get(0);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			if(st.countTokens() > 1) {
				String order = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				push(x);
			} else {
				String order = st.nextToken();
				if("size".equals(order)) System.out.println(size());
				else if("empty".equals(order)) System.out.println(empty());
				else if("pop".equals(order)) System.out.println(pop());
				else System.out.println(top());
			}
			
		}
		
	}
}
