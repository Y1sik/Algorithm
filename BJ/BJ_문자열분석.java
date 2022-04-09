package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_문자열분석 {
	static String str;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while((str = br.readLine()) != null) {
			char ch[] = str.toCharArray();
			int count[] = new int[4];
			for (char c : ch) {
				if('a' <= c && c <= 'z') {
					count[0]++;
				}else if('A' <= c && c <= 'Z') {
					count[1]++;
				}else if('0' <= c && c <= '9') {
					count[2]++;
				}else {
					count[3]++;
				}
			}
			System.out.println(count[0] + " " + count[1] + " " + count[2] + " " + count[3]);
		}
		
	}

}
