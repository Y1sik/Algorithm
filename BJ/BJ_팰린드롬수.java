package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_ÆÓ¸°µå·Ò¼ö {
	static String str;
	static char[] arr1;
	static char[] arr2;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			str = br.readLine();
			if(str.equals("0")) {
				break;
			}
			int len = str.length();
			arr1 = new char[len];
			arr2 = new char[len];
			
			for (int i = 0; i < len; i++) {
				arr1[i] = str.charAt(i);
			}
			for (int i = 0; i < len; i++) {
				arr2[i] = arr1[len - 1 - i];
			}
			for (int i = 0; i < len; i++) {
				if(arr1[i] == arr2[i]) {
					cnt++;
				}
			}
			
			if(len == cnt) System.out.println("yes");
			else System.out.println("no");
			cnt = 0;
		}
		
	}

}
