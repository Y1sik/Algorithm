package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_팰린드롬인지확인하기 {
	static String str;
	static char[] s1;
	static char[] s2;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();

		s1 = new char[str.length()];
		s2 = new char[str.length()];

		for (int i = 0; i < str.length(); i++) {
			s1[i] = str.charAt(i);
		}
		for (int i = 0; i < str.length(); i++) {
			s2[i] = s1[str.length() - 1 - i];
		}
		for (int i = 0; i < str.length(); i++) {
			if(s1[i] == s2[i]) {
				cnt++;
			}
		}
		
		if(cnt == str.length()) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}

}
