package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_ũ�ξ�Ƽ�ƾ��ĺ� {
	static String str;
	static String[] cro = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		
		for (int i = 0; i < cro.length; i++) {
			if(str.contains(cro[i])) {
				str = str.replace(cro[i], "*");
			}
		}
		
		System.out.println(str.length());
	}

}
