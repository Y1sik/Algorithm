package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_±ÕÇüÀâÈù¼¼»ó {
	static String str;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			str = br.readLine();
			Stack<Character> stack = new Stack<>();
			boolean check = true;
			
			if(str.equals(".")) {
				break;
			}
			
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(' || str.charAt(i) == '[') {
					stack.push(str.charAt(i));
				}
				else if (str.charAt(i) == ')') {
					if(stack.empty() || stack.peek() != '(') {
						check = false;
						break;
					}else {
						stack.pop();
					}
				}else if (str.charAt(i) == ']') {
					if(stack.empty() || stack.peek() != '[') {
						check = false;
						break;
					}else {
						stack.pop();
					}
				}
			}
			
			if(check && stack.empty()) System.out.println("yes");
			else System.out.println("no");
			
		}

	}

}
