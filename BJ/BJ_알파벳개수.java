package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_¾ËÆÄºª°³¼ö {
	static String s;
	static int[] alpabet;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();

		alpabet = new int[26];

		for (int i = 0; i < s.length(); i++) {
			alpabet[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			System.out.print(alpabet[i] + " ");

		}

	}

}
