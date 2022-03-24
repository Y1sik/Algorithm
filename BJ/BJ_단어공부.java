package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_단어공부 {
	static String str;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		arr = new int[26];
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
				arr[c - 'A']++;
			}else {
				arr[c - 'a']++;
			}
		}
		
		int max = 0;
		char ch = '?';
		
		for (int i = 0; i < 26; i++) {
			if(arr[i] > max) {
				max = arr[i];
				ch = (char) (i + 'A');
			}
			else if (arr[i] == max) {
				ch = '?';
			}
		}
		System.out.println(ch);
	}

}
