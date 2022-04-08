package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ_AC {
	static int T;
	static String calc;
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			calc = br.readLine();
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			ArrayDeque<Integer> deque = new ArrayDeque<>();
			for (int j = 0; j < N; j++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			
			AC(calc, deque);
		}
		System.out.println(sb.toString());

	}
	private static void AC(String calc, ArrayDeque<Integer> deque) {
		boolean isDirection = true;
		
		for (int i = 0; i < calc.length(); i++) {
			if(calc.charAt(i) == 'R') {
				isDirection = !isDirection;
				continue;
			}
			
			if(isDirection) {
				if(deque.pollFirst() == null) {
					sb.append("error").append("\n");
					return;
				}
			}else {
				if(deque.pollLast() == null) {
					sb.append("error").append("\n");
					return;
				}
			}
			
		}
		printAC(deque, isDirection);
		
	}
	private static void printAC(ArrayDeque<Integer> deque, boolean isDirection) {
		sb.append('[');
		
		if(deque.size() > 0) {
			if(isDirection) {
				sb.append(deque.pollFirst());
				
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			}else {
				sb.append(deque.pollLast());
				
				while(!deque.isEmpty()) {
					sb.append(',').append(deque.pollLast());
				}
			}
		}
		
		sb.append(']').append('\n');
		
	}

}
