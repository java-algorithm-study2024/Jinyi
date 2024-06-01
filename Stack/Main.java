package shinhan_study2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			boolean check = false;
			String[] str = br.readLine().split("");
			Stack<String> stack = new Stack<>();
			for(int j = 0; j < str.length; j++) {
				if("(".equals(str[j])) stack.push("(");
				else {
					if(stack.size() > 0) stack.pop();
					else {
						System.out.println("NO");
						check = true;
						break;
					}
				}
			}
			if(!check) {
				if(stack.size() > 0) System.out.println("NO");
				else System.out.println("YES");
			}
			
		}
	}
}
