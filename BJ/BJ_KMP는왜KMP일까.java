package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_KMP는왜KMP일까 {
	static String str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		while(st.hasMoreElements()) {
			str = st.nextToken();
			sb.append(str.charAt(0));
		}
		System.out.println(sb.toString());
	}

}
