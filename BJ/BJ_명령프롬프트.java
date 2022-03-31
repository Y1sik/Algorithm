package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_명령프롬프트 {
	static int n;
	static String[] str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		str = new String[n];
		
		for (int i = 0; i < n; i++) {
			str[i] = br.readLine();
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str[0].length(); i++) {
			char c = str[0].charAt(i);
			boolean check = true;
			
			for (int j = 0; j < n; j++) {
				if(str[j].charAt(i) == c) {
					check = true;
				}else {
					check = false;
					break;
				}
			}
			if(check) {
				sb.append(c);
			}else {
				sb.append('?');
			}
			
		}
		System.out.println(sb.toString());

	}

}
