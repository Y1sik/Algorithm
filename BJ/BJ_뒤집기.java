package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_µÚÁý±â {
	static String S;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		int zero = 0;
		int one = 0;
		
		char pre = S.charAt(0);
		if(pre == '0') {
			zero++;
		}else {
			one++;
		}
		for (int i = 1; i < S.length(); i++) {
			if(pre != S.charAt(i)) {
				if(S.charAt(i) == '0') {
					zero++;
					pre = S.charAt(i);
				}else {
					one++;
					pre = S.charAt(i);
				}
			}
		}
		if(zero == 0 || one == 0) {
			System.out.println(0);
		}else if(zero > one) {
			System.out.println(one);
		}else if (zero <= one) {
			System.out.println(zero);
		}
	}

}
