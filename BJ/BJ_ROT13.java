package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_ROT13 {
	static String str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		str = br.readLine();
		
		for (int i = 0; i < str.length(); i++) {
			int a = str.charAt(i);
			
			if(a >= 65 && a <= 90) {
				a += 13;
				
				if(a > 90) {
					int b = a - 91;
					a = 65+b;
				}
			} else if (a >= 97 && a <= 122) {
				a += 13;
				
				if(a > 122) {
					int b = a-123;
					a = 97 + b;
				}
			}
			sb.append((char)a);
		}
		
		System.out.println(sb.toString());
		
	}

}
