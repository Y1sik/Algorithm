package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_¹®ÀÚ¿­Æø¹ß {
	static String str;
	static String boom;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		boom = br.readLine();
		
		BoomStr();

	}
	private static void BoomStr() {
		int strLen = str.length();
		int boomLen = boom.length();
		Stack<Character> st = new Stack<>();
		
		for (int i = 0; i < strLen; i++) {
			char c = str.charAt(i);
			st.push(c);
			
			if(st.size() >= boomLen) {
				boolean isSame = true;
				for (int j = 0; j < boomLen; j++) {
					char c1 = st.get(st.size() - boomLen + j);
					char c2 = boom.charAt(j);
					
					if(c1 != c2) {
						isSame = false;
						break;
					}
				}
				if(isSame) {
					for (int j = 0; j < boomLen; j++) {
						st.pop();
					}
				}
			}
		}
		
		if(st.size() == 0) {
			System.out.println("FRULA");
		} else {
			StringBuilder sb = new StringBuilder();
			for (char c : st) {
				sb.append(c);
			}
			System.out.println(sb.toString());
		}
		
		
	}

}
