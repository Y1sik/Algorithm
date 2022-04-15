package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_µÚÁýÈùµ¡¼À {
	static String X, Y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		X = st.nextToken();
		Y = st.nextToken();
		
		System.out.println(Rev(Integer.toString((Rev(X) + Rev(Y)))));

	}
	private static int Rev(String num) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < num.length(); i++) {
			st.add(num.charAt(i));
		}
		num = "";
		while(!st.isEmpty()) {
			num += st.pop();
		}
		return Integer.parseInt(num);
		
	}

}
