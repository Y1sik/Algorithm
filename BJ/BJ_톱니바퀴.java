package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_Åé´Ï¹ÙÄû {
	static LinkedList<Integer>[] gear;
	static int k;
	static int index, dir;
	static int[] isValid;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		gear = new LinkedList[4];
		
		for (int i = 0; i < 4; i++) {
			gear[i] = new LinkedList<>();
		}
		
		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				gear[i].add(str.charAt(j) - '0');
			}
		}
		
		k = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			index = Integer.parseInt(st.nextToken()) - 1;
			dir = Integer.parseInt(st.nextToken());
			isValid = new int[4];
			check(index, dir);
			rotate(isValid);
		}
		int result = calc();
		System.out.println(result);

	}
	private static int calc() {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			if (gear[i].get(0) == 1) {
				result += Math.pow(2, i);
			}
		}
		return result;
	}
	private static void rotate(int[] isValid) {
		for (int i = 0; i < 4; i++) {
			if(isValid[i] == 1) {
				int temp = gear[i].pollLast();
				gear[i].addFirst(temp);
			}else if(isValid[i] == -1) {
				int temp = gear[i].pollFirst();
				gear[i].addLast(temp);
			}
		}
		
	}
	private static void check(int index, int dir) {
		isValid[index] = dir;
		
		int prev = index - 1;
		int post = index + 1;
		
		if(prev >= 0 && isValid[prev] == 0) {
			if(gear[prev].get(2) != gear[index].get(6)) {
				check(prev, dir * -1);
			}
		}
		
		if(post <= 3 && isValid[post] == 0) {
			if(gear[post].get(6) != gear[index].get(2)) {
				check(post, dir * -1);
			}
		}
	}

}
