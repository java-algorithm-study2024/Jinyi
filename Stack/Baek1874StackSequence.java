import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		List<String> list = new ArrayList<>();
		boolean check = false;
		int k = 1;
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			while(k <= num) {
				stack.push(k);
				list.add("+");
				k++;
			}
			if(stack.peek() == num) {
				stack.pop();
				list.add("-");
			} else {
				System.out.println("NO");
				check = true;
				break;
			}
		}
		if(!check) {
			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
	}
}
