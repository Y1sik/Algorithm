package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ_접미사배열 {
	static String str;
	static String[] suffix;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		suffix = new String[str.length()];
		for (int i = 0; i < str.length(); i++) {
			if(i == 0) {
				suffix[0] = str;
			}else {
				suffix[i] = str.substring(i);
			}
		}
		Arrays.sort(suffix);
		for (int i = 0; i < suffix.length; i++) {
			System.out.println(suffix[i]);
		}
	}

}
