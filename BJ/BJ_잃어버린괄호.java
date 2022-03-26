package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_ÀÒ¾î¹ö¸°°ýÈ£ {
	static String[] str;
	static int temp;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine().split("-");
		for (int i = 0; i < str.length; i++) {
			temp = 0;
			String[] add = str[i].split("\\+");
			for (int j = 0; j < add.length; j++) {
				temp += Integer.parseInt(add[j]);
			}
			if(i == 0) {
				result = temp;
			}else {
				result -= temp;
			}
		}
		System.out.println(result);
	}

}
