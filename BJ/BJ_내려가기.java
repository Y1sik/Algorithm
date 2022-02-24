package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_내려가기 {
	static int N;
	static int[] maxdp;
	static int[] mindp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		maxdp = new int[3];
		mindp = new int[3];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(i == 0) {
				maxdp[0] = a;
				maxdp[1] = b;
				maxdp[2] = c;
				
				mindp[0] = a;
				mindp[1] = b;
				mindp[2] = c;
			}
			else {
				int beforemax = maxdp[1];
				maxdp[1] = Math.max(Math.max(maxdp[0], maxdp[1]), maxdp[2]) + b;
				maxdp[0] = Math.max(maxdp[0], beforemax) + a;
				maxdp[2] = Math.max(beforemax, maxdp[2]) + c;
				
				int beforemin = mindp[1];
				mindp[1] = Math.min(Math.min(mindp[0], mindp[1]), mindp[2]) + b;
				mindp[0] = Math.min(mindp[0], beforemin) + a;
				mindp[2] = Math.min(beforemin, mindp[2]) + c;
			}
		}
		
		System.out.println(Math.max(Math.max(maxdp[0], maxdp[1]), maxdp[2]) + " " + Math.min(Math.min(mindp[0], mindp[1]), mindp[2]));

	}

}
