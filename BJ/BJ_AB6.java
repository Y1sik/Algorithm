package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_AB6 {
	static int T;
	static int A, B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), ",");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			System.out.println(A + B);
		}
		
		
		
	}

}
