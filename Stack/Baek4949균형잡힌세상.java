import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			boolean check = false;
			if(".".equals(str)) break;
			
			Stack<String> stack = new Stack<>();
			for(String ch : str.split("")) {
				if("(".equals(ch) || "[".equals(ch)) {		// 여는 괄호는 stack 에 push()
					stack.push(ch);
				} else if(")".equals(ch)) {					// 닫는 괄호인 경우
					if(stack.isEmpty() || !"(".equals(stack.peek())) {
						System.out.println("no");
						check = true;
						break;
					}
					stack.pop();
				} else if("]".equals(ch)) {
					if(stack.isEmpty() || !"[".equals(stack.peek())) {
						System.out.println("no");
						check = true;
						break;
					}
					
					stack.pop();
				}
			}
			
			if(!check) {
				if(stack.isEmpty()) System.out.println("yes");
				else System.out.println("no");
			}
		}
	}
}
