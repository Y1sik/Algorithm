package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_º°Âï±â11 {
	static int N;
	static String[] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new String[N];
		
		map[0] = "  *  ";
		map[1] = " * * ";
		map[2] = "*****";
		
		for (int i = 1; 3*(int)Math.pow(2, i) <= N; i++) {
			Star(i);
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(map[i]);
		}
		
	}
	private static void Star(int k) {
		int end = 3 * (int)Math.pow(2, k);
		int mid = end / 2;
		
		for (int i = mid; i < end; i++) {
			map[i] = map[i - mid] + " " + map[i - mid];
		}
		
		String empty = "";
		
		while(empty.length() < mid) {
			empty += " ";
		}
		for (int i = 0; i < mid; i++) {
			map[i] = empty + map[i] + empty;
		}
	}
	

}
