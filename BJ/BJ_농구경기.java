package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_³ó±¸°æ±â {
	static int N;
	static String str;
	static int[] alpabet;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		alpabet = new int[26];
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			char c = str.charAt(0);
			alpabet[c - 97]++;
		}
		boolean flag = false;
		for (int i = 0; i < alpabet.length; i++) {
			if (alpabet[i] >= 5) {
				System.out.print((char) (i + 97));
				flag = true;
			}
		}
		if (!flag)
			System.out.println("PREDAFA");
	}

}
