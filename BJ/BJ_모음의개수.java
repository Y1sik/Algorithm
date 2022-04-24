package BJ;

import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class BJ_모음의개수 {
	static int[] alpa;
	static String str;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		
		alpa = new int[26];
		
		for (int i = 0; i < str.length(); i++) {
			alpa[str.charAt(i) - 'a']++;
		}
		
		result = alpa['a' - 'a'] + alpa['e' - 'a'] + alpa['i' - 'a'] + alpa['o' - 'a'] + alpa['u' - 'a'];
		
		System.out.println(result);
	}

}
