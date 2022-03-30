package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_ÇÏ¾áÄ­ {
	static char[][] map = new char[8][8];
	static String str;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 8; i++) {
			str = br.readLine();
			for (int j = 0; j < 8; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(i % 2 == 0 && j % 2 == 0) {
					if(map[i][j] == 'F') result++;
				}else if (i % 2 == 1 && j % 2 == 1) {
					if(map[i][j] == 'F') result++;
				}
			}
		}
		System.out.println(result);

	}

}
