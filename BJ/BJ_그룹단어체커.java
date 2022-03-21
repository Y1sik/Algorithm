package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_그룹단어체커 {
	static int N;
	static String str;
	static boolean[] check;
	static ArrayList<Character> al;
	static int result;
	public static void main(String[] args) throws IOException {
		// 다음 단어가 같은 지 판단
		// 다르면 새로운 값 -> 이미 있는 값이면 N - 1
		// 같으면 유지
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		result = N;
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			
			if(!check()) {
				result--;
			}
			
		}

		System.out.println(result);

	}
	private static boolean check() {
		check = new boolean[26];
		int prev = 0;
		for (int i = 0; i < str.length(); i++) {
			int now = str.charAt(i);
			if(now != prev) {
				if(check[now - 'a'] == false) {
					check[now - 'a'] = true;
					prev = now;
				}else {
					return false;
				}
			}else {
				continue;
			}
		}
		return true;
	}

}
