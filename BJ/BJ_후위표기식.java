package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_후위표기식 {
	static String str;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		sb = new StringBuilder();
		
		prefix(str);
		System.out.println(sb.toString());
		

	}
	private static void prefix(String str) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char now = str.charAt(i); 
			switch (now) {
			case '+':
			case '-':
			case '*':
			case '/':
				while(!stack.isEmpty() && priority(stack.peek()) >= priority(now)) {
					sb.append(stack.pop());
				}
				stack.push(now);
				break;
			case '(':
				stack.push(now);
				break;
			case ')':
				while(!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
				break;
			default:
				stack.push(now);
				break;
			}
		}
		
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
	}
	private static int priority(Character operation) {
		// TODO Auto-generated method stub
		if(operation == '(' || operation == ')') {
			return 0;
		}else if(operation == '+' || operation == '-') {
			return 1;
		}else {
			return 2;
		}
	}
	
	

}
