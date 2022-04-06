package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_세로읽기 {
	static String str;
	static char[][] chs = new char[5][15];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				chs[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if(chs[j][i]== ' ' || chs[j][i]=='\0') {
					continue;
				}

				System.out.print(chs[j][i]);
			}
		}

	}

}
