package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_단어뒤집기 {
	static int n;
	static String str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			while(st.hasMoreTokens()) {
				String a = st.nextToken();
				for (int j = 0; j < a.length(); j++) {
					char b = a.charAt(a.length() - 1 - j);
					
					sb.append(b);
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		

	}

}
