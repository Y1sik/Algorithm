package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_진법변환 {
	static String n;
	static int b;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = st.nextToken();
		b = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		for (int i = 0; i < n.length(); i++) {
			char c = n.charAt(i);
			if('A' <= c && c <= 'Z') {
				ans = ans * b + ((c - 'A') + 10);
			} else {
				ans = ans * b + (c - '0');
			}
		}
		System.out.println(ans);
	}	

}
