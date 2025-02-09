import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static ArrayDeque<Integer> stack = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			if("2".equals(str)) {
				System.out.println(pop());
			} else if("3".equals(str)) {
				System.out.println(size());
			} else if("4".equals(str)) {
				System.out.println(isEmpty());
			} else if("5".equals(str)) {
				System.out.println(peek());
			} else {
				StringTokenizer st = new StringTokenizer(str, " ");
				int x = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());
				push(x);
			}
		}
		
	}
	
	static void push(int x) {
		stack.push(x);
	}
	static int pop() {
		if(!stack.isEmpty())
			return stack.pop();
		return -1;
	}
	static int size() {
		return stack.size();
	}
	static int isEmpty() {
		if(stack.isEmpty()) return 1;
		return 0;
	}
	static int peek() {
		if(!stack.isEmpty()) return stack.peek();
		return -1;
	}
}
